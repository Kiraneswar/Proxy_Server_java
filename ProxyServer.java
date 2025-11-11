// Simplified Server
import java.io.*;
import java.net.*;

public class ProxyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Proxy server running on port 8080...");
        while (true) {
            Socket client = server.accept();
            new Thread(new ClientHandler(client)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;
    ClientHandler(Socket c) { this.client = c; }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

            String urlString = in.readLine();
            URL url = new URL(urlString);
            BufferedReader web = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = web.readLine()) != null)
                out.println(line);
            web.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

