mvn package spring-boot:repackage &&
sudo docker-compose build --no-cache
sudo docker-compose stop
sudo docker-compose rm -f
sudo docker-compose up --force-recreate -d