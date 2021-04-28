FROM openjdk:11

ADD build/libs/ciencuadras-integracion-crm-ms*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar" ]