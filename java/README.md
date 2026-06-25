# Java REST example

Uses the JDK stdlib `com.sun.net.httpserver` with virtual threads (Project Loom).
No external dependencies.

## Requirements

- JDK 25

## Build

```
./gradlew jar
```

## Run

```
java -jar build/libs/java-rest-service.jar
```

## Test performance

```
ab -n 1000 -c 4 http://localhost:4567/hello
```
