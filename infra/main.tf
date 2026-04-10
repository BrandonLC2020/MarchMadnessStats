# =============================================================================
# March Madness Stats — AWS Infrastructure
# =============================================================================

terraform {
  required_version = ">= 1.5"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }

  # Uncomment after creating the state bucket (see README.md for bootstrap steps)
  # backend "s3" {
  #   bucket         = "march-madness-stats-tf-state"
  #   key            = "terraform.tfstate"
  #   region         = "us-east-1"
  #   dynamodb_table = "march-madness-stats-tf-lock"
  #   encrypt        = true
  # }
}

provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      Project     = var.project_name
      Environment = var.environment
      ManagedBy   = "terraform"
    }
  }
}

# -----------------------------------------------------------------------------
# Data Sources
# -----------------------------------------------------------------------------

data "aws_caller_identity" "current" {}
data "aws_region" "current" {}

# -----------------------------------------------------------------------------
# Modules
# -----------------------------------------------------------------------------

module "networking" {
  source = "./modules/networking"

  project_name         = var.project_name
  environment          = var.environment
  vpc_cidr             = var.vpc_cidr
  backend_container_port = var.backend_container_port
}

module "ecr" {
  source = "./modules/ecr"

  project_name = var.project_name
  environment  = var.environment
}

module "secrets" {
  source = "./modules/secrets"

  project_name = var.project_name
  environment  = var.environment
}

module "ecs" {
  source = "./modules/ecs"

  project_name           = var.project_name
  environment            = var.environment
  aws_region             = var.aws_region
  ecr_repository_url     = module.ecr.repository_url
  backend_container_port = var.backend_container_port
  backend_cpu            = var.backend_cpu
  backend_memory         = var.backend_memory
  backend_desired_count  = var.backend_desired_count
  private_subnet_ids     = module.networking.private_subnet_ids
  ecs_security_group_id  = module.networking.ecs_security_group_id
  alb_target_group_arn   = module.networking.alb_target_group_arn
  ssm_parameter_arns     = module.secrets.parameter_arns
}

module "frontend" {
  source = "./modules/frontend"

  project_name = var.project_name
  environment  = var.environment
}
