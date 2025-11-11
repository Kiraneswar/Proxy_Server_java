import java.io.*;
import java.net.*;

public class ProxyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String url = "https://example.com";
        out.println(url);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null)
            sb.append(line).append("\n");

        String filename = url.replaceAll("https?://", "").replaceAll("[/:]", "_") + ".html";
        FileWriter writer = new FileWriter("downloads/" + filename);
        writer.write(sb.toString());
        writer.close();
        socket.close();
        System.out.println("Saved " + filename);
    }
}

