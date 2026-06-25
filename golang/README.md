# Golang REST example

Uses the standard library `net/http.ServeMux` with Go 1.22+ method-qualified routing. No external dependencies.

## Requirements

- Go 1.22+

## Run

```
go run .
```

## Test performance

```
ab -n 1000 -c 4 http://localhost:8000/
```
