# 基于官方的 OpenJDK 运行时镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 将打包的 JAR 文件复制到镜像中
COPY target/runnerz-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露应用程序运行的端口（可根据你的应用程序设置）
EXPOSE 8080

# 运行 Java 应用程序
ENTRYPOINT ["java", "-jar", "app.jar"]
