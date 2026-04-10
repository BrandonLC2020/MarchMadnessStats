output "cloudfront_url" {
  description = "CloudFront distribution domain name."
  value       = "https://${aws_cloudfront_distribution.frontend.domain_name}"
}

output "cloudfront_distribution_id" {
  description = "CloudFront distribution ID (needed for cache invalidation during deploys)."
  value       = aws_cloudfront_distribution.frontend.id
}

output "s3_bucket_name" {
  description = "S3 bucket name for frontend build artifacts."
  value       = aws_s3_bucket.frontend.id
}

output "s3_bucket_arn" {
  description = "S3 bucket ARN."
  value       = aws_s3_bucket.frontend.arn
}
