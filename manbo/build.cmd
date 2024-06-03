mvnw clean
mvnw package
docker build -t yuris127/manbo-project-back:latest .
docker push yuris127/manbo-project-back:latest
