output "parameter_arns" {
  description = "ARNs of all SSM parameters (for IAM policy)."
  value = [
    aws_ssm_parameter.cbb_api_key.arn,
    aws_ssm_parameter.firebase_api_key.arn,
    aws_ssm_parameter.firebase_project_id.arn,
    aws_ssm_parameter.firebase_auth_domain.arn,
    aws_ssm_parameter.firebase_storage_bucket.arn,
    aws_ssm_parameter.firebase_messaging_sender_id.arn,
    aws_ssm_parameter.firebase_app_id.arn,
    aws_ssm_parameter.firebase_measurement_id.arn,
    aws_ssm_parameter.gemini_api_key.arn,
  ]
}

output "cbb_api_key_arn" {
  description = "ARN of the CBB API key parameter."
  value       = aws_ssm_parameter.cbb_api_key.arn
}
