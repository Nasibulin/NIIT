package javatemp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

class ServerElement extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedReader inc;
    private PrintWriter out;

    public ServerElement(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        inc  = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        start();
    }

    public void run() {
        try {
            String str;
            while ((str = inc.readLine()) != null) {
//                System.out.println(str);
                if (str.equals("exit"))
                    break;
                System.out.println("Получен запрос времени от : " + socket.getInetAddress());
                out.println(LocalDateTime.now());
                //out.flush();
            }
            System.out.println("Соединение закрыто");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Сокет не закрыт");
            }
        }
    }
}

public class TimeServer {
    static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        System.out.println("Мультипоточный сервер стартовал");
        try (ServerSocket s = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = s.accept();
                try {
                    System.out.println("Новое соединение установлено");
                    new ServerElement(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}
