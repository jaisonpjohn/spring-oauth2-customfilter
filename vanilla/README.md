This project shows what you can do with the minimum configuration to
set up a Resource Server.
This resource server is configured to talk to an Authorization server, you can configure the application.yaml file to use a different Auth server if you need.

## Building

You need Java (1.7 or better) and Maven (3.0.5 or better):

```
$ mvn package
$ java -jar target/*.jar
...
<app starts and listens on port 8090>
```

Here are some curl commands to use to get started:

```
$ TOKEN=b561ff06-4259-466e-92d8-781db1a5190 (whatever token you are getting from the Auth server)
$ curl -H "Authorization: Bearer $TOKEN" localhost:8090/
Hello World
```
