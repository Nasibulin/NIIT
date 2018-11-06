package javalab6;

//: TIEJ:X1:MultiJabberServer1.java
// ����� ��� � ���������, ��� � �������������
// MultiJabberServer
// {RunByHand}
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.*;

/**
 * ������ ��������� ���������� �� ����������� ��������. ����� ����������
 * �����������, ��������� �����, ������� �������������� � ���������� ���
 * ������/������. ������/������ ����������� ��� ���� �������, ����� ��������
 * ��������������. ��� ��������� �������� ����� ��� ��, ��� � MultiJabberServer.
 */
public class MultiJabberServer1 {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // ����� ����� ������ ������ � ByteBuffer, ����������
        // ������� PrintWriter.println(). ������������� ����� ������
        // ���� ������� ������� �������� ��� ��������� �� ���������.
        String encoding = System.getProperty("file.encoding");
        // �������������� �����, ��� ��� �� �� ����� ��������� �����
        // ��������� ��������� ������ ���, ����� ��� ����������
        // Charset cs = Charset.forName(
        // System.getProperty("file.encoding"));
        Charset cs = Charset.forName(encoding);
        ByteBuffer buffer = ByteBuffer.allocate(16);
        SocketChannel ch = null;
        ServerSocketChannel ssc = ServerSocketChannel.open();
        Selector sel = Selector.open();
        try {
            ssc.configureBlocking(false);
            // ���������� �����, �� ������� �� ����� ������� ����������
            // ����������: Socket.getChannel() ���������� null, ���� � ��� ��
            // ������������ �����, ��� �������� ����.
            // �.� ��������� (ssc.socket().getChannel() != null) �����������
            ssc.socket().bind(new InetSocketAddress(PORT));
            // ����� ������������� � �������� OP_ACCEPT
            SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
            System.out.println("Server on port: " + PORT);
            while (true) {
                sel.select();
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey skey = (SelectionKey) it.next();
                    it.remove();
                    if (skey.isAcceptable()) {
                        ch = ssc.accept();
                        System.out.println("Accepted connection from:"
                                                   + ch.socket());
                        ch.configureBlocking(false);
                        ch.register(sel, SelectionKey.OP_READ);
                    }
                    else {
                        // �������� ��������, ��� �� ����������� ��������, ����
                        // � �����
                        // ����� ������ ��� ������ - ��� ���������.
                        ch = (SocketChannel) skey.channel();
                        ch.read(buffer);
                        CharBuffer cb = cs.decode((ByteBuffer) buffer.flip());
                        String response = cb.toString();
                        System.out.print("Echoing : " + response);
                        ch.write((ByteBuffer) buffer.rewind());
                        if (response.indexOf("END") != -1)
                            ch.close();
                        buffer.clear();
                    }
                }
            }
        }
        finally {
            if (ch != null)
                ch.close();
            ssc.close();
            sel.close();
        }
    }
} // /:~
