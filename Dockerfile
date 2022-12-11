FROM openjdk:11
ADD target/irrigation-demo-docker.jar irrigation-demo-docker.jar
ENTRYPOINT ["java", "-jar","irrigation-demo-docker.jar"]
EXPOSE 8080