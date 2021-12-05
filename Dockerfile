FROM openjdk:11-jre

EXPOSE 4000

ADD target/searchbar-0.0.1-SNAPSHOT.jar searchbar-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "searchbar-0.0.1-SNAPSHOT.jar"]