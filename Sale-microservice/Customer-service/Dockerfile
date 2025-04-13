# Base image
FROM openjdk:17-jdk-slim

# Cài đặt curl để tải và cài đặt wait-for-it
RUN apt-get update && apt-get install -y curl && \
    curl -sS https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh -o /wait-for-it.sh && \
    chmod +x /wait-for-it.sh

# Thư mục làm việc
WORKDIR /app

# Copy jar file vào image
COPY target/Customer-service-0.0.1-SNAPSHOT.jar app.jar

# Cổng ứng dụng
EXPOSE 8082

# Command khởi chạy, đợi MariaDB sẵn sàng rồi mới chạy ứng dụng
ENTRYPOINT ["/wait-for-it.sh", "customer-db:3306", "--", "java", "-jar", "app.jar"]
