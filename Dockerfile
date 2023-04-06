FROM openjdk:17
EXPOSE 8080
COPY target/PMS-Capstone-Final-0.0.1-SNAPSHOT.jar g1-pms-patientInfo.jar
CMD [ "java","-jar","g1-pms-patientInfo.jar" ]