# Base image
FROM openjdk:17-jdk-slim

# Thư mục làm việc
WORKDIR /app

# Copy jar file vào image
COPY target/Customer-service-0.0.1-SNAPSHOT.jar app.jar

# Cổng ứng dụng
EXPOSE 8082

# Command khởi chạy
ENTRYPOINT ["java", "-jar", "app.jar"]