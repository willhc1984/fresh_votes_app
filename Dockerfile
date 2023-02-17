
FROM openjdk

WORKDIR /app

COPY fresh_votes_app.jar /app/fresh_votes_app.jar

ENTRYPOINT ["java", "-jar", "fresh_votes_app.jar"]