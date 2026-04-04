---
name: skill-mm-automation
description: Project-specific automation for March Madness Stats, including OpenAPI watching, environment validation, and rate-limit monitoring. Use when setting up or maintaining the development environment.
---

# March Madness Automation Skill

This skill provides automated workflows and "hooks" for the March Madness Stats development lifecycle.

## Automated Hooks

### OpenAPI Watcher
Monitors `backend/src/main/resources/schemas/swagger.json` and triggers backend generation.
- **Run**: `node scripts/watch_openapi.cjs`
- **When to use**: When making active changes to the API schema.

### Firebase Environment Validator
Ensures all required environment variables are set in the `frontend/.env` file.
- **Run**: `node scripts/validate_env.cjs`
- **When to use**: Before starting the frontend development server or after cloning the project.

### CBB API Rate-Limit Monitor
Parses backend logs to report on current API usage and rate limits.
- **Run**: `node scripts/monitor_rate_limit.cjs`
- **When to use**: When experiencing API failures or during high-load testing.

## Reference

- **Frontend Variables**: `LOCAL_BASE_URL`, `FIREBASE_API_KEY`, `FIREBASE_AUTH_DOMAIN`, `FIREBASE_PROJECT_ID`, `FIREBASE_STORAGE_BUCKET`, `FIREBASE_MESSAGING_SENDER_ID`, `FIREBASE_APP_ID`, `GEMINI_API_KEY`.
- **Backend Variables**: `CBB_API_KEY`.
