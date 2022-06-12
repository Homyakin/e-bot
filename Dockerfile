FROM bellsoft/liberica-openjdk-alpine-musl:18.0.1-12

RUN apk update
RUN apk add tzdata
RUN apk add tesseract-ocr
ENV TZ=Europe/Moscow

COPY ./target/e-bot-1.0.jar /home/e-bot-1.0.jar
COPY ./tesseract/ /home/tesseract

CMD java -jar /home/e-bot-1.0.jar /home/tesseract