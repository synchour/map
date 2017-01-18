FROM java:8

COPY /map/ /map/

WORKDIR /map

RUN ./build.sh 
# Injecting production variables

CMD ["java", "-jar", "./target/art-0.0.1.jar"]