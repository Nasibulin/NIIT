package javalab6;

//: TIEJ:X1:MultiJabberServer2.java
// Семантика аналогична MultiJabberServer1, с использованием пула нитей.
// {RunByHand}
import java.io.*;

import java.net.*;

import java.nio.*;

import java.nio.channels.*;

import java.nio.charset.*;

import java.util.*;

class ServeOneJabber1 implements Runnable {
    private SocketChannel channel;
    private Selector sel;

    public ServeOneJabber1(SocketChannel ch) throws IOException {
        channel = ch;
        sel = Selector.open();
    }

    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        boolean read = false, done = false;
        String response = null;
        try {
            channel.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            while (!done) {
                sel.select();
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    it.remove();
                    if (key.isReadable() && !read) {
                        if (channel.read(buffer) > 0)
                            read = true;
                        CharBuffer cb = MultiJabberServer2.CS
                                .decode((ByteBuffer) buffer.flip());
                        response = cb.toString();
                    }
                    if (key.isWritable() && read) {
                        System.out.print("Echoing : " + response);
                        channel.write((ByteBuffer) buffer.rewind());
                        if (response.indexOf("END") != -1)
                            done = true;
                        buffer.clear();
                        read = false;
                    }
                }
            }
        }
        catch (IOException e) {
            // будет поймано Worker.java и залогировано.
            // Необходимо выбросить исключение времени выполнения, так как мы не
            // можем
            // оставить IOException
            throw new RuntimeException(e);
        }
        finally {
            try {
                channel.close();
            }
            catch (IOException e) {
                System.out.println("Channel not closed.");
                // Выбрасываем это, чтобы рабочая нить могла залогировать.
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiJabberServer2 {
    public static final int PORT = 8080;
    private static String encoding = System.getProperty("file.encoding");
    public static final Charset CS = Charset.forName(encoding);
    // Создаем пул нитей с 20 рабочими нитями.
    private static ThreadPool pool = new ThreadPool(20);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        Selector sel = Selector.open();
        try {
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(PORT));
            SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
            System.out.println("Server on port: " + PORT);
            while (true) {
                sel.select();
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey skey = (SelectionKey) it.next();
                    it.remove();
                    if (skey.isAcceptable()) {
                        SocketChannel channel = ssc.accept();
                        System.out.println("Accepted connection from:"
                                                   + channel.socket());
                        channel.configureBlocking(false);
                        // Отделяем события и ассоциированное действие
                        pool.addTask(new ServeOneJabber1(channel));
                    }
                }
            }
        }
        finally {
            ssc.close();
            sel.close();
        }
    }
} // /:~
