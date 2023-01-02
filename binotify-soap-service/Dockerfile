FROM maven:3-amazoncorretto-8
WORKDIR /app
COPY pom.xml pom.xml
COPY demo.iml demo.iml
RUN --mount=type=cache,target=/root/.m2 mvn clean
COPY src src
RUN --mount=type=cache,target=/root/.m2 mvn compile assembly:single
EXPOSE 8080
# ENTRYPOINT [ "mvn", "exec:java" ]
ENTRYPOINT [ "java", "-jar", "./target/demo-1.0-SNAPSHOT-jar-with-dependencies.jar" ]
