package javalab6;

//: c15:JabberClient.java
// ����� ������� ������, ������� ������ ��������
// ������ �� ������ � ������ ������,
// ���������� ��������.
// {RunByHand}
import java.net.*;

import java.io.*;

public class JabberClient {
    public static void main(String[] args) throws IOException {
        // �������� null � getByName(), �������
        // ����������� IP ����� "��������� ��������"
        // ��� ������������ �� ������ ��� ����:
        InetAddress addr = InetAddress.getByName(null);
        // �������������, �� ������ ������������
        // ����� ��� ���:
        // InetAddress addr =
        // InetAddress.getByName("127.0.0.1");
        // InetAddress addr =
        // InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, JabberServer.PORT);
        // �������� ��� � ���� try-finally, �����
        // ���� ���������, ��� ����� ���������:
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                                                                                 .getInputStream()));
            // ����� ������������� Output ������������� PrintWriter'��.
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            for (int i = 0; i < 10; i++) {
                out.println("howdy " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        }
        finally {
            System.out.println("closing...");
            socket.close();
        }
    }
} // /:~
