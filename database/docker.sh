docker stop ebot-db
docker rm ebot-db
docker build -f Dockerfile -t ebot-db-img .
docker run --name ebot-db -p 27017:27017 -d ebot-db-img
