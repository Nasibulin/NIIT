package javatemp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client {
    static final int PORT = 1234;
    static final String HOST = "localhost";
    static String fuser = "gettime";
    static String fserver = "";

    public static LocalDateTime dt() throws IOException {

        Socket server = null;
        server = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(server.getInputStream()));
        PrintWriter out =
                new PrintWriter(server.getOutputStream(), true);

        while (!fuser.equals("exit")) {
            out.println(fuser);
            fserver = in.readLine();
            if (fuser.equalsIgnoreCase("exit"))
                break;
            fuser = "exit";
        }
        out.close();
        in.close();
        server.close();
        return LocalDateTime.parse(fserver);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(dt());
        System.out.println(dt().format(DateTimeFormatter.ofPattern("d MMMM uuuu HH:mm:ss.mm.SSS")));
    }
}
