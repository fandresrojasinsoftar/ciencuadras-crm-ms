#!/bin/bash

./gradlew compileJava compileTestJava assemble build

docker build -t ciencuadras-integracion-crm-ms .

docker run --name ciencuadras-integracion-crm-ms -p 80:80 -d ciencuadras-integracion-crm-ms
