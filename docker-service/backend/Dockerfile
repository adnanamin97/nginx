FROM openjdk:17-jdk-slim
RUN mkdir /content
COPY target/nginx-server.jar .
COPY src/main/resources/static /content
EXPOSE 8080
ENTRYPOINT ["java","-jar","nginx-server.jar"]