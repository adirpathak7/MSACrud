# ServerApp

Your description here

# Project information

The project starts out with a fully configured minimal JakartaEE 9 setup and HelloWorld endpoint

# Project Commands 

| Command          | Description                                                                                                                                                                                                                                                 |
|:-----------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| run              | Start docker locally and expose docker volume `/opt/payara/payara5/glassfish/domains/domain1/autodeploy` to directory `./artifact` so that every time `mvn package` is run locally it will automatically redeploy the application in the docker environment |
| build            | will build the application and the docker image                                                                                                                                                                                                             |
| build-run        | will build the application and the docker image and run locally                                                                                                                                                                                             |
| build-deploy     | will build the application and the docker image and deploy that image to the docker registry                                                                                                                                                                |
| buildx-boodstrap | will bootstrap docker buildx for multi platform builds                                                                                                                                                                                                      |
| buildx-deploy    | will build the application and the docker image for amd64 and arm64 architectures                                                                                                                                                                           |
| buildx-stop      | removes the buildx multi-platform config (cleanup)                                                                                                                                                                                                          |
| logs             | will show the logs if run with `build-run`                                                                                                                                                                                                                  |

# Docker

- The docker image is hosted:
  - [ivonet/payara](http://ivo2u.nl/tM) / [GitHub](http://ivo2u.nl/oO)
  - [ivonet/glassfish](http://ivo2u.nl/tP) / [GitHub](http://ivo2u.nl/Vu)


```shell
docker build -t DOCKER_HANDLE/IMAGE_NAME .
docker push DOCKER_HANDLE/IMAGE_NAME
```

Make sure to replace DOCKER_HANDLE/IMAGE_NAME with actual values.

# Example endpoint

- [http://localhost:8080/ServerApp/rest/example](http://localhost:8080/ServerApp/rest/example)
- [health check url](http://localhost:8080/health)

# Drop in replacement

The payara/server-full docker image en the ivonet/payara images are almost drop-in
replacements of each other.

One of the main reasons the ivonet/payara image is used is that I as the maker have control
over the java version I want to use and I can create a multi-platform build. 

At the time this archetype was published there was only an amd64 build of te official payara 
docker image.

