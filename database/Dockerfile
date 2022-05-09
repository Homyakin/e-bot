FROM mongo:5.0.8-focal

ENV MONGO_INITDB_ROOT_USERNAME=ebot
ENV MONGO_INITDB_ROOT_PASSWORD=12345
ENV MONGO_INITDB_DATABASE=ebase

COPY ./init/fill-data.js /docker-entrypoint-initdb.d/fill-data.js

EXPOSE 27017
