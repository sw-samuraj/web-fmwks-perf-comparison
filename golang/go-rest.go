package main

import (
	"log"
	"net/http"
)

func helloWorld(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/plain")
	w.Write([]byte("Hello, world!"))
}

func main() {
	mux := http.NewServeMux()
	mux.HandleFunc("GET /", helloWorld)
	log.Fatal(http.ListenAndServe(":8000", mux))
}
