# March Madness Stats — AWS Infrastructure

Terraform configurations for deploying the March Madness Stats application to AWS.

## Architecture

| Component | AWS Service | Purpose |
|-----------|-------------|---------|
| Frontend (React SPA) | S3 + CloudFront | Static hosting with CDN, HTTPS, edge caching |
| Backend (Spring Boot) | ECS Fargate | Serverless containers behind ALB |
| Container Images | ECR | Private Docker registry |
| Secrets | SSM Parameter Store | Secure storage for API keys |
| Networking | VPC + ALB | Isolated network with load balancing |

## Prerequisites

- [Terraform](https://developer.hashicorp.com/terraform/install) >= 1.5
- [AWS CLI](https://aws.amazon.com/cli/) configured with appropriate credentials
- [Docker](https://docs.docker.com/get-docker/) (for building backend images)

## Quick Start

```bash
# 1. Initialize Terraform
cd infra
terraform init

# 2. Review the plan for dev
terraform plan -var-file=environments/dev.tfvars

# 3. Apply (creates all AWS resources)
terraform apply -var-file=environments/dev.tfvars

# 4. Set secrets (replace placeholders created by Terraform)
aws ssm put-parameter \
  --name "/march-madness-stats/dev/cbb-api-key" \
  --value "YOUR_ACTUAL_KEY" \
  --type SecureString \
  --overwrite
```

## Deploying the Backend

```bash
# 1. Build the Docker image
cd march-madness-stats/backend
docker build -t mms-backend .

# 2. Tag and push to ECR
aws ecr get-login-password --region us-east-1 | \
  docker login --username AWS --password-stdin <ACCOUNT_ID>.dkr.ecr.us-east-1.amazonaws.com

ECR_URL=$(terraform -chdir=../../infra output -raw ecr_repository_url)
docker tag mms-backend:latest $ECR_URL:latest
docker push $ECR_URL:latest

# 3. Force new deployment
aws ecs update-service \
  --cluster march-madness-stats-dev-cluster \
  --service march-madness-stats-dev-backend \
  --force-new-deployment
```

## Deploying the Frontend

```bash
# 1. Build the React app
cd march-madness-stats/frontend
npm run build

# 2. Sync to S3
S3_BUCKET=$(terraform -chdir=../../infra output -raw frontend_s3_bucket)
aws s3 sync build/ s3://$S3_BUCKET --delete

# 3. Invalidate CloudFront cache
CF_DIST_ID=$(terraform -chdir=../../infra output -raw cloudfront_distribution_url)
aws cloudfront create-invalidation --distribution-id $CF_DIST_ID --paths "/*"
```

## Module Structure

```
infra/
├── main.tf                    # Provider, backend, module wiring
├── variables.tf               # Root input variables
├── outputs.tf                 # Root outputs
├── terraform.tfvars.example   # Variable template
├── environments/
│   ├── dev.tfvars             # Dev overrides (small, cheap)
│   └── prod.tfvars            # Prod overrides (HA, larger)
└── modules/
    ├── networking/            # VPC, subnets, ALB, security groups
    ├── ecr/                   # Container registry + lifecycle policy
    ├── ecs/                   # Cluster, task def, service, IAM
    ├── frontend/              # S3 bucket, CloudFront, OAC
    └── secrets/               # SSM Parameter Store entries
```

## Remote State (Optional)

To enable remote state with S3 + DynamoDB locking:

```bash
# 1. Create the state bucket and lock table (one-time)
aws s3api create-bucket \
  --bucket march-madness-stats-tf-state \
  --region us-east-1

aws dynamodb create-table \
  --table-name march-madness-stats-tf-lock \
  --attribute-definitions AttributeName=LockID,AttributeType=S \
  --key-schema AttributeName=LockID,KeyType=HASH \
  --billing-mode PAY_PER_REQUEST \
  --region us-east-1

# 2. Uncomment the backend "s3" block in main.tf

# 3. Re-initialize Terraform
terraform init -migrate-state
```

## Environments

Use the `-var-file` flag to target different environments:

```bash
# Dev (smaller, cheaper)
terraform plan -var-file=environments/dev.tfvars

# Prod (HA, larger resources)
terraform plan -var-file=environments/prod.tfvars
```

## Teardown

```bash
# Destroy all resources for an environment
terraform destroy -var-file=environments/dev.tfvars
```

> ⚠️ **Warning**: This will delete all resources including the S3 bucket contents and ECR images. Make sure to back up anything important first.
