import java.io.*;
import java.net.*;
import java.util.*;

public class ProxyClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner in = new Scanner(socket.getInputStream());

        String url = "https://example.com";
        out.println(url);

        StringBuilder page = new StringBuilder();
        while (in.hasNextLine()) {
            page.append(in.nextLine()).append("\n");
        }

        String filename = url.replaceAll("https?://", "")
                             .replaceAll("[/:]", "_") +
                            "_"+ System.currentTimeMillis()+
                             ".html";

        File dir = new File("downloads");
        if (!dir.exists()) dir.mkdir();

        FileWriter writer = new FileWriter("downloads/" + filename);
        writer.write(page.toString());
        writer.close();

        System.out.println("Saved file: " + filename);

        socket.close();
    }
}
