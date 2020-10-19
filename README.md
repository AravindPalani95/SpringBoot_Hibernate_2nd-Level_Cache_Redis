# Spring Boot - Hibernate 2nd Level Cache With Redis

A Simple Microservice which use Redis as a 2nd level cache in Hibernate.

## Installation

Configure and Install [Redis](https://redis.io/topics/quickstart).


## Usage

Start redis-Server and redis-cli in new terminal

Terminal 1

```bash
src/redis-server
```

Terminal 2
```bash
src/redis-cli
127.0.0.1:6379> AUTH <password>
OK
127.0.0.1:6379> MONITOR
```

Run the Microservice and test via Swagger URL.

[http://localhost:8080/api/swagger-ui.html]()
