# set base image (host OS)
FROM openjdk:11.0.4-jre

# set the working directory in the container
WORKDIR /app

# copy the dependencies file to the working directory
COPY /ml-orderpago-challenge/backend/ChallengePlaceToPay/target/ChallengePlaceToPay-0.0.1-SNAPSHOT.jar /app/ChallengePlaceToPay-0.0.1-SNAPSHOT.jar

# port Expose
EXPOSE 9080

# run
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ChallengePlaceToPay-0.0.1-SNAPSHOT.jar"]

