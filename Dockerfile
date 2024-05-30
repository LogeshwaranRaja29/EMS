FROM maven:3.8.3-openjdk-17
CMD mvn clean install
EXPOSE 8080
ADD target/EMS-0.0.1-SNAPSHOT.jar EMS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EMS-0.0.1-SNAPSHOT.jar"]