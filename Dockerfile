# 用稳定可用的 OpenJDK 镜像
FROM openjdk:11-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 Maven 构建后的 jar 包
COPY target/*.jar app.jar

# 暴露 9090 端口（和你代码里的配置保持一致）
EXPOSE 9090

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]