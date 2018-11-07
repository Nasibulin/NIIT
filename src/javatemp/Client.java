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

    public static LocalDateTime getDateTine() throws IOException {

        try (
                Socket server = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter out = new PrintWriter(server.getOutputStream(), true)
        ) {
            out.println(fuser);
            fserver = in.readLine();
        }
        return LocalDateTime.parse(fserver);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getDateTine());
        System.out.println(getDateTine().format(DateTimeFormatter.ofPattern("d MMMM uuuu HH:mm:ss.mm.SSS")));
    }
}
