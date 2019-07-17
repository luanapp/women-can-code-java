FROM openjdk:8-jdk-alpine

# default environment variables
ARG PORT=8080
ARG JAR_FILE=target/user-role-rbac-0.0.1-SNAPSHOT.jar

VOLUME [ "/data" ]
EXPOSE ${PORT}

# copy jar file to execution point
COPY ${JAR_FILE} /wcc/application/app.jar

WORKDIR /wcc/application
ENTRYPOINT [ "java", "-jar", "app.jar" ]