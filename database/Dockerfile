FROM mongo:5.0.8-focal

ENV MONGO_INITDB_ROOT_USERNAME=root
ENV MONGO_INITDB_ROOT_PASSWORD=root
ENV MONGO_INITDB_DATABASE=ebase

COPY ./init/init-mongo.js /docker-entrypoint-initdb.d/init-mongo.js
COPY ./init/fill-data.js /docker-entrypoint-initdb.d/fill-data.js

EXPOSE 27017
