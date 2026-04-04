---
name: skill-reactive-java
description: Advanced guidance for Spring Boot 3 WebFlux (Reactive) development, including Flux/Mono orchestration and non-blocking CBB API interaction. Use when developing or refactoring the backend Edge Service.
---

# Reactive Java Backend Skill

This skill provides expert patterns for the Spring Boot WebFlux "Edge Service" that powers March Madness Stats.

## Reactive Principles

- **Never Block**: Use `Mono` and `Flux` for all I/O operations (API calls, DB access). Avoid `Thread.sleep()`, blocking calls, and traditional loops on heavy data.
- **Composition over Execution**: Use operators like `flatMap`, `zipWith`, and `switchIfEmpty` to chain operations instead of imperative blocks.
- **Backpressure**: Leverage built-in WebFlux backpressure to handle large data streams from the CBB API.

## Core Patterns

### API Orchestration (CbbApiService)
Always use `WebClient` for external calls.

```java
public Flux<Team> getTeamsByConference(String conference) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/teams").queryParam("conference", conference).build())
        .retrieve()
        .bodyToFlux(Team.class)
        .onErrorResume(e -> Flux.empty());
}
```

### Complex Transformations
Use `zip` or `zipWith` to combine multiple async data sources.

```java
public Mono<TeamDetails> getTeamDetails(String teamId) {
    return Mono.zip(
        getTeamStats(teamId),
        getTeamRoster(teamId),
        (stats, roster) -> new TeamDetails(stats, roster)
    );
}
```

### Error Handling
Always provide a fallback using `onErrorResume` or `onErrorReturn` to ensure the reactive pipeline continues.

## Performance Optimization
- **Parallel processing**: Use `flatMap` with a concurrency hint for independent API requests.
- **Caching**: Use `cache()` on long-lived `Mono` or `Flux` instances if they are frequently requested.
