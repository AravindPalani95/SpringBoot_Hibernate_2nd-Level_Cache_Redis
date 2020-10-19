# Spring Boot - Hibernate 2nd Level Cache With Redis

A Simple Microservice which use Redis as a 2nd level cache in Hibernate.

## Installation

Configure and Install [Redis](https://redis.io/topics/quickstart).


## Usage

Start <b>redis-server</b> and <b>redis-cli</b> in new terminal

<b>Terminal 1</b>

```bash
src/redis-server
```

<b>Terminal 2</b>
```bash
src/redis-cli
127.0.0.1:6379> AUTH <password>
OK
127.0.0.1:6379> MONITOR
```

Run the Microservice and test via <b>Swagger</b> URL.

[http://localhost:8080/api/swagger-ui.html]()

Check Redis CLI

```bash
127.0.0.1:6379> HGETALL AccountBalanceCache
```
