# Builder container
FROM maven:3.6-jdk-8-alpine AS builder

RUN mkdir -p /build/wcc
WORKDIR /build/wcc/
COPY . .

VOLUME [ "/data" ]

RUN mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec > ./version
RUN mvn clean package
RUN mv ./target/user-role-rbac-`cat ./version`.jar ./app.jar

# Backend container
FROM openjdk:8-jdk-alpine

# default environment variables
ARG PORT=8080
ARG JAR_FILE=app.jar

VOLUME [ "/data" ]
EXPOSE ${PORT}

# copy jar file to execution point
COPY --from=builder /build/wcc/${JAR_FILE} /wcc/application/app.jar

WORKDIR /wcc/application
ENTRYPOINT [ "java", "-jar", "app.jar" ]