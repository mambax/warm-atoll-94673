FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/warm-atoll-94673-0.0.1-SNAPSHOT.jar warm-atoll-94673-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/warm-atoll-94673-0.0.1-SNAPSHOT.jar"]