import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ProxyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(socket.getInputStream()));

        String url = "https://example.com";
        out.println(url);

        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()){ 
            String line=in.nextLine();
            sb.append(line).append("\n");
        }

        File dir=new File("downloads");
        if(!dir.exists()) dir.mkdir();

        String filename = url.replaceAll("https?://", "").replaceAll("[/:]", "_") + ".html";
        FileWriter writer = new FileWriter("downloads/" + filename);
        writer.write(sb.toString());
        writer.close();
        socket.close();
        System.out.println("Saved " + filename);
    }
}

