FROM openjdk:8
ADD target/bin-checker.jar bin-checker.jar
EXPOSE 8585
ENTRYPOINT ["java", "-jar", "bin-checker.jar"]