# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

March Madness Stats is a full-stack NCAA Men's College Basketball statistics application:

- **Backend** (`march-madness-stats/backend/`): Spring Boot 3 "Edge Service" — proxies all data requests to the external [College Basketball Data API](https://collegebasketballdata.com/) using Spring WebFlux (reactive).
- **Frontend** (`march-madness-stats/frontend/`): React 19 SPA with MUI 7, Plotly.js charts, Firebase (favorites/persistence), and Gemini AI analysis.

---

## Commands

### Backend (from `march-madness-stats/backend/`)
```bash
mvn clean install    # Build + run OpenAPI code generation (required first)
mvn spring-boot:run  # Start on port 8080
mvn test             # Run tests
```

### Frontend (from `march-madness-stats/frontend/`)
```bash
npm install   # Install dependencies
npm start     # Start dev server on port 3000 (proxy → localhost:8080)
npm run build # Production build
npm test      # Run tests
```

---

## Environment Setup

Copy `march-madness-stats/sample.env` and populate values. The backend `.env` lives in `march-madness-stats/` (loaded by `java-dotenv`). The frontend `.env` lives in `march-madness-stats/frontend/`.

Required variables:
- **Backend**: `CBB_API_KEY` — College Basketball Data API key
- **Frontend**: `REACT_APP_LOCAL_BASE_URL`, `REACT_APP_FIREBASE_*` (7 keys), `REACT_APP_GEMINI_API_KEY`

The `npm start` `prestart` hook (`scripts/validate_env.cjs`) validates all frontend env vars before starting.

---

## Architecture

### Data Flow
```
React View → custom hook → apiHelper.ts → GET /endpoint
  → Spring Controller → CbbApiService (WebClient) → External CBB API
```

### Backend Key Patterns
- **OpenAPI-first**: API interfaces and model POJOs are generated from `src/main/resources/schemas/swagger.json` into `target/generated-sources/`. Never edit files in the generated `com.blc.backend.api` (interfaces) or `com.blc.backend.model` (POJOs) packages directly.
- **Reactive service layer**: `CbbApiService` returns `Flux<T>`/`Mono<T>`. Controllers call `.block()` to bridge to synchronous REST responses.
- **Config**: `WebConfig` handles CORS (allows `localhost:3000`) and type converters. `JacksonConfig` configures Jackson for Java 8 date/time and OpenAPI nullable types.

### Frontend Key Patterns
- **Custom hooks** in `src/hooks/` encapsulate all data fetching (e.g. `useGames`, `useTeams`, `useStats`). Each hook wraps calls through `apiHelper.ts`.
- **`apiHelper.ts`** is the single fetch utility — reads `REACT_APP_LOCAL_BASE_URL`, attaches auth headers, and provides typed `fetchData<T>()`.
- **Type definitions** in `src/types/api.ts` mirror the backend OpenAPI models. Keep these in sync when `swagger.json` changes.
- **Views** (`src/views/`) are page-level route components. **Components** (`src/components/`) are reusable UI pieces.
- **Styling**: Use MUI `SxProps` / Emotion. Avoid global CSS.

### When API Changes Are Needed
1. Edit `march-madness-stats/backend/src/main/resources/schemas/swagger.json`
2. Run `mvn clean install` to regenerate backend models/interfaces
3. Implement the controller method
4. Update `src/types/api.ts` in the frontend to match
