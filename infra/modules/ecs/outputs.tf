output "cluster_id" {
  description = "ECS cluster ID."
  value       = aws_ecs_cluster.main.id
}

output "cluster_name" {
  description = "ECS cluster name."
  value       = aws_ecs_cluster.main.name
}

output "service_name" {
  description = "ECS service name."
  value       = aws_ecs_service.backend.name
}

output "task_definition_arn" {
  description = "ARN of the ECS task definition."
  value       = aws_ecs_task_definition.backend.arn
}

output "task_execution_role_arn" {
  description = "ARN of the task execution IAM role."
  value       = aws_iam_role.task_execution.arn
}
