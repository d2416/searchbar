FROM openjdk:11

ADD target/searchbar-0.0.1-SNAPSHOT.jar searchbar_app.jar

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "searchbar_app.jar"]