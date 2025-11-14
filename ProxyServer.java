import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ProxyServer {

    private static final int THREAD_POOL_SIZE = 20;

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Proxy Server running on port 8080...");
        System.out.println("Thread pool size: " + THREAD_POOL_SIZE);

        while (true) {
            Socket client = server.accept();
            pool.execute(new ClientHandler(client));
        }
    }
}
