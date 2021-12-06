FROM openjdk:11-jre

ADD target/searchbar-0.0.1-SNAPSHOT.jar searchbar-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "searchbar-0.0.1-SNAPSHOT.jar"]