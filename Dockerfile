FROM openjdk:11
EXPOSE 8080
ADD target/backend-seniguard.jar backend-seniguard.jar
ENTRYPOINT ["java","-jar","/backend-seniguard.jar"]