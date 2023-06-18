# Sample nginx and spring mvc project

This is a sample repository for setting up with spring mvc and nginx.


To run this service run

```docker-compose -f nginx-docker-compose.yaml up --build```

The nginx proxy should be exposed on your local machine at port 8080. Simply type http://localhost:8080/ to get redirected to the nginx sample page.

This project is configured to redirect the `/sample` path to the applications `/` endpoint in `default.conf`

On start up, this file will be mounted on to the nginx proxy container 