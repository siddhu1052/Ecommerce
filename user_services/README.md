Swagger URL
http://localhost:8083/swagger-ui/index.html#/

Docker 

FROM openjdk:18.0slim
COPY target/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java,"-jar,"/app.jar"]


Docker File 

# # ---------- STAGE 1: Build the JAR ----------
# FROM maven:3.9.9-eclipse-temurin-17 AS builder

# WORKDIR /build

# COPY pom.xml .
# COPY src ./src

# RUN mvn clean package -DskipTests


# # ---------- STAGE 2: Run the application ----------
# FROM eclipse-temurin:17-jdk-alpine

# WORKDIR /app

# COPY --from=builder /build/target/*.jar app.jar

# EXPOSE 5000

# ENTRYPOINT ["java", "-jar", "app.jar"]


# ---------- STAGE 1: Build the JAR ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# ---------- STAGE 2: Run the application ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]
