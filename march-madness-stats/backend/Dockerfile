# =============================================================================
# Backend Dockerfile — Multi-stage Build
# =============================================================================
# Build:  docker build -t mms-backend .
# Run:    docker run -p 8080:8080 --env-file ../.env mms-backend
# =============================================================================

# --------------- Stage 1: Build ----------------------------------------------
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Cache Maven dependencies first (layer caching optimization)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests -B

# --------------- Stage 2: Runtime --------------------------------------------
FROM eclipse-temurin:21-jre-alpine

# Security: run as non-root user
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

WORKDIR /app

# Copy the fat JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set ownership
RUN chown -R appuser:appgroup /app

USER appuser

# Spring Boot default port
EXPOSE 8080

# JVM flags optimized for containers
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

HEALTHCHECK --interval=30s --timeout=5s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
