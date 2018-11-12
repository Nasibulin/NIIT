package javatemp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

class ServerOne extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOne(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        start();
    }

    public void run() {
        String str="";
        try {
            while ((str = in.readLine()) != null) {
                if (str.equals("close"))
                    break;
                if (str.equals("exit"))
                    break;
                System.out.println("Получено: " + str);
                out.println(LocalDateTime.now());
            }
            System.out.println("Соединение закрыто");
        } catch (IOException e) {
            System.err.println("Ошибка чтения/записи");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Сокет не закрыт");
            }
        }
    }
}

public class MultiServer {
    static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Мультипоточный сервер стартовал");
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    System.out.println("Новое соединение установлено");
                    new ServerOne(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}
