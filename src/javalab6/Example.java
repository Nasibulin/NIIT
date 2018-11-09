package javalab6;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Example {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectEchoServer server = new ObjectEchoServer("127.0.0.1", 1234);
             Client client = new Client("127.0.0.1", 1234);) {
            Message message = new Message("qwerty", 12345);
            //client.sendObject(message);
            client.sendObject(LocalDateTime.now());
            client.receiveObject();
        }
    }

    public static class Message implements Serializable {
        private static final long serialVersionUID = 574898633726487420L;
        public final String string;
        public final int number;

        public Message(String string, int number) {
            this.string = string;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Message [string=" + string + ", number=" + number + "]";
        }
    }

    public static class ObjectMessenger {
        protected final Socket socket;
        private Logger log = Logger.getLogger(this.getClass().getName());

        public ObjectMessenger(Socket socket) throws UnknownHostException, IOException {
            this.socket = socket;
        }

        public void sendObject(Object object) throws IOException {
            log.info("Отправляется объект: " + object);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(object);
            oos.flush();
        }

        public Object receiveObject() throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object object = ois.readObject();
            log.info("Принят объект: " + ((LocalDateTime)object).getDayOfWeek());
            return object;
        }
    }

    public static class Client extends ObjectMessenger implements AutoCloseable, Closeable {
        public Client(String host, int port) throws UnknownHostException, IOException {
            super(new Socket(host, port));
        }

        @Override
        public void close() throws IOException {
            socket.close();
        }
    }

    public static class ObjectEchoServer implements AutoCloseable, Closeable {
        private final ServerSocket serverSocket;

        public ObjectEchoServer(String host, int port) throws IOException {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(host, port));
            new Thread() {
                {
                    setDaemon(true);
                }

                @Override
                public void run() {
                    for (; ; ) {
                        try {
                            final Socket socket = serverSocket.accept();
                            new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        try {
                                            while (socket.isConnected()) {
                                                ObjectMessenger messenger = new ObjectMessenger(socket);
                                                Object object = messenger.receiveObject();
                                                messenger.sendObject(object);
                                            }
                                        } catch (EOFException ignored) {
                                        } finally {
                                            socket.close();
                                        }
                                    } catch (IOException | ClassNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }

                                ;
                            }.start();
                        } catch (IOException ex) {
                            if (!serverSocket.isClosed()) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
            }.start();
        }

        @Override
        public void close() throws IOException {
            serverSocket.close();
        }
    }
}
