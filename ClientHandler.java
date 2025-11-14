import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() +
                               " handling request...");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String urlString = in.readLine();
            System.out.println("Handling URL: " + urlString);

            URL url = new URL(urlString);

            BufferedReader web = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String line;
            while ((line = web.readLine()) != null) {
                out.println(line);
            }

            web.close();
            client.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
