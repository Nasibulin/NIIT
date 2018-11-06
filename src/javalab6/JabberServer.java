package javalab6;

//: c15:JabberServer.java
// ќчень простой сервер, который просто отсылает
// назад все, что посылает клиент.
// {RunByHand}
import java.io.*;

import java.net.*;

public class JabberServer {
    // ¬ыбираем порт вне пределов 1-1024:
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started: " + s);
        try {
            // Ѕлокирует до тех пор, пока не возникнет соединение:
            Socket socket = s.accept();
            try {
                System.out.println("Connection accepted: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                // ¬ывод автоматически выталкиваетс€ из буфера PrintWriter'ом
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())), true);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END"))
                        break;
                    System.out.println("Echoing: " + str);
                    out.println(str);
                }
                // ¬сегда закрываем два сокета...
            }
            finally {
                System.out.println("closing...");
                socket.close();
            }
        }
        finally {
            s.close();
        }
    }
} // /:~