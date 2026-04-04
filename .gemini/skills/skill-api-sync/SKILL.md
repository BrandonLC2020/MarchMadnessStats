---
name: skill-api-sync
description: Skill for maintaining parity between Spring Boot (OpenAPI/Swagger) models and React (TypeScript) interfaces. Use when adding endpoints or updating the backend data schema.
---

# API Synchronization Skill

This skill ensures consistent data typing between the backend Edge Service and the frontend application.

## Core Workflow

1. **Update Schema**: Edit `backend/src/main/resources/schemas/swagger.json` to define new models or endpoints.
2. **Generate Backend**: Run `mvn clean install` in the `backend/` directory to regenerate Java interfaces and models.
3. **Synchronize Frontend**: Update `frontend/src/types/api.ts` to match the generated backend models.

## Type Mapping Reference

| OpenAPI / Java | TypeScript |
| :--- | :--- |
| `Integer`, `Double`, `Float`, `Long` | `number` |
| `String`, `UUID` | `string` |
| `Boolean` | `boolean` |
| `List<T>`, `Set<T>` | `T[]` |
| `Map<String, T>` | `Record<string, T>` |
| `OffsetDateTime`, `LocalDate` | `string` (ISO format) |

## Best Practices

- **Enums**: Always define enums in `swagger.json` so they are generated correctly as Java enums and can be mapped to TypeScript string literal types or enums.
- **Nullable Fields**: Explicitly mark required fields in `swagger.json`. Frontend types should reflect optionality (`fieldName?: type`).
- **Validation**: After updating `api.ts`, run `npm run build` or `tsc` in the frontend to find breaking changes.
