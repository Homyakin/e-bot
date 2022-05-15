FROM bellsoft/liberica-openjdk-alpine-musl:18.0.1-12

RUN apk update && apk add tzdata
ENV TZ=Europe/Moscow

COPY ./target/e-bot-1.0.jar /home/e-bot-1.0.jar

CMD ["java","-jar","/home/e-bot-1.0.jar"]