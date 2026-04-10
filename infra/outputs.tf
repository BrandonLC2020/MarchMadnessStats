# =============================================================================
# Outputs
# =============================================================================

# -- Frontend -----------------------------------------------------------------

output "cloudfront_distribution_url" {
  description = "CloudFront distribution URL for the React frontend."
  value       = module.frontend.cloudfront_url
}

output "frontend_s3_bucket" {
  description = "S3 bucket name hosting the frontend build artifacts."
  value       = module.frontend.s3_bucket_name
}

# -- Backend ------------------------------------------------------------------

output "alb_dns_name" {
  description = "ALB DNS name for the Spring Boot backend."
  value       = module.networking.alb_dns_name
}

output "ecr_repository_url" {
  description = "ECR repository URL for backend Docker images."
  value       = module.ecr.repository_url
}

# -- Networking ---------------------------------------------------------------

output "vpc_id" {
  description = "VPC ID."
  value       = module.networking.vpc_id
}
