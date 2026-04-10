# =============================================================================
# Secrets Module — SSM Parameter Store
# =============================================================================
#
# Parameters are created with placeholder values. Set actual values via:
#   aws ssm put-parameter --name "/<project>/<env>/cbb-api-key" \
#     --value "YOUR_KEY" --type SecureString --overwrite
# =============================================================================

resource "aws_ssm_parameter" "cbb_api_key" {
  name        = "/${var.project_name}/${var.environment}/cbb-api-key"
  description = "API key for the College Basketball Data API"
  type        = "SecureString"
  value       = "PLACEHOLDER" # Set real value via CLI or Console

  tags = {
    Name = "${var.project_name}-${var.environment}-cbb-api-key"
  }

  lifecycle {
    ignore_changes = [value] # Prevent Terraform from overwriting manually-set secrets
  }
}

resource "aws_ssm_parameter" "firebase_api_key" {
  name        = "/${var.project_name}/${var.environment}/firebase-api-key"
  description = "Firebase API key"
  type        = "SecureString"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-api-key"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_project_id" {
  name        = "/${var.project_name}/${var.environment}/firebase-project-id"
  description = "Firebase project ID"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-project-id"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_auth_domain" {
  name        = "/${var.project_name}/${var.environment}/firebase-auth-domain"
  description = "Firebase auth domain"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-auth-domain"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_storage_bucket" {
  name        = "/${var.project_name}/${var.environment}/firebase-storage-bucket"
  description = "Firebase storage bucket"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-storage-bucket"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_messaging_sender_id" {
  name        = "/${var.project_name}/${var.environment}/firebase-messaging-sender-id"
  description = "Firebase messaging sender ID"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-messaging-sender-id"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_app_id" {
  name        = "/${var.project_name}/${var.environment}/firebase-app-id"
  description = "Firebase app ID"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-app-id"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "firebase_measurement_id" {
  name        = "/${var.project_name}/${var.environment}/firebase-measurement-id"
  description = "Firebase measurement ID"
  type        = "String"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-firebase-measurement-id"
  }

  lifecycle {
    ignore_changes = [value]
  }
}

resource "aws_ssm_parameter" "gemini_api_key" {
  name        = "/${var.project_name}/${var.environment}/gemini-api-key"
  description = "Google Gemini API key for AI analysis features"
  type        = "SecureString"
  value       = "PLACEHOLDER"

  tags = {
    Name = "${var.project_name}-${var.environment}-gemini-api-key"
  }

  lifecycle {
    ignore_changes = [value]
  }
}
