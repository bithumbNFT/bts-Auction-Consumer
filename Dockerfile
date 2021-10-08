FROM openjdk:11-jdk-slim
LABEL maintainer="BTS"
VOLUME /tmp
ARG JAR_FILE=./*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 9090
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/Auction","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]