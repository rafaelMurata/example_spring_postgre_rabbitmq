FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/example-0.1.jar /opt/app
CMD ["java", "-jar", "/opt/app/example-0.1.jar"]