FROM bellsoft/liberica-openjdk-alpine-musl:18.0.1-12

COPY ./target/e-bot-1.0.jar /home/e-bot-1.0.jar

CMD ["java","-jar","/home/e-bot-1.0.jar"]