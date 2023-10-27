
# 使用一个包含 Maven 和 JDK 17 的基础镜像
FROM maven:3.8.3-openjdk-17-slim AS build

# 复制你的源代码和 pom.xml 文件到容器中
COPY . /app
COPY maven.xml /usr/share/maven/conf/setting.xml
# 在容器中运行 Maven 以构建你的应用程序
WORKDIR /app
RUN mvn clean package -Dmaven.test.skip=true

# 使用另一个基础镜像来运行你的应用程序
FROM openjdk:17-slim

# 从构建阶段复制构建的应用程序到新的基础镜像中
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
# 设置应用程序的入口点
ENTRYPOINT ["java","-jar","app.jar"]