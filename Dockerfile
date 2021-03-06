FROM java:8

# Copy essentials for the build
COPY /map/pom.xml /map/
COPY /map/mvnw /map/
COPY /map/build.sh /map/
COPY /map/.mvn/ /map/.mvn/

COPY /src-template/ /map/src

WORKDIR /map

# First build form a cache image
RUN ./build.sh 

# Copy the real source code
RUN rm -fr /map/src/
COPY /map/src /map/src

WORKDIR /map
RUN ./build.sh

#EXPOSE 8000

CMD ["java", "-jar", "./target/map-0.0.1-SNAPSHOT.jar"]