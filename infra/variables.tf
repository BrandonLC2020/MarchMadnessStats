# =============================================================================
# Input Variables
# =============================================================================

variable "aws_region" {
  description = "AWS region for all resources. us-east-1 is required if using CloudFront with ACM."
  type        = string
  default     = "us-east-1"
}

variable "project_name" {
  description = "Project name used for resource naming and tagging."
  type        = string
  default     = "march-madness-stats"
}

variable "environment" {
  description = "Deployment environment (dev, staging, prod)."
  type        = string
  default     = "dev"

  validation {
    condition     = contains(["dev", "staging", "prod"], var.environment)
    error_message = "Environment must be one of: dev, staging, prod."
  }
}

# -- Networking ---------------------------------------------------------------

variable "vpc_cidr" {
  description = "CIDR block for the VPC."
  type        = string
  default     = "10.0.0.0/16"
}

# -- Backend (ECS Fargate) ---------------------------------------------------

variable "backend_container_port" {
  description = "Port the Spring Boot application listens on."
  type        = number
  default     = 8080
}

variable "backend_cpu" {
  description = "Fargate task CPU units (256 = 0.25 vCPU)."
  type        = number
  default     = 256
}

variable "backend_memory" {
  description = "Fargate task memory in MiB."
  type        = number
  default     = 512
}

variable "backend_desired_count" {
  description = "Number of backend ECS tasks to run."
  type        = number
  default     = 1
}
