variable "project_name" {
  description = "Project name for resource naming."
  type        = string
}

variable "environment" {
  description = "Deployment environment."
  type        = string
}

variable "aws_region" {
  description = "AWS region for CloudWatch log configuration."
  type        = string
}

variable "ecr_repository_url" {
  description = "ECR repository URL for the backend image."
  type        = string
}

variable "backend_container_port" {
  description = "Port the backend container listens on."
  type        = number
}

variable "backend_cpu" {
  description = "Fargate task CPU units."
  type        = number
}

variable "backend_memory" {
  description = "Fargate task memory in MiB."
  type        = number
}

variable "backend_desired_count" {
  description = "Number of backend tasks to run."
  type        = number
}

variable "private_subnet_ids" {
  description = "Private subnet IDs for ECS tasks."
  type        = list(string)
}

variable "ecs_security_group_id" {
  description = "Security group ID for ECS tasks."
  type        = string
}

variable "alb_target_group_arn" {
  description = "ALB target group ARN to register ECS tasks with."
  type        = string
}

variable "ssm_parameter_arns" {
  description = "ARNs of SSM parameters the task execution role can read."
  type        = list(string)
}
