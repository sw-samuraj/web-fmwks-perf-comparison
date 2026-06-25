package blog.swsamuraj;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Hello {
    public static void main(String[] args) throws Exception {
        var server = HttpServer.create(new InetSocketAddress(4567), 0);
        server.createContext("/hello", exchange -> {
            var body = "Hello world!".getBytes();
            exchange.sendResponseHeaders(200, body.length);
            try (var out = exchange.getResponseBody()) {
                out.write(body);
            }
        });
        server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        server.start();
        System.out.println("Server started on port 4567");
    }
}
