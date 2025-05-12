# Build
FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR /app
COPY pom.xml .
RUN apt-get update && \
    apt-get install -y maven && \
    mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/auth-service-*.jar ./app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:+ExitOnOutOfMemoryError -XX:HeapDumpPath=/app/heapdump.hprof"
EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar