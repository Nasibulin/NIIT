package javatemp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestASClient {

    public static void main(String[] args) throws InterruptedException {

        try(Socket socket = new Socket("localhost", 3345);
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream()); )
        {

            System.out.println("Client connected to socket.");
            System.out.println();
            System.out.println("Client writing channel = oos & reading channel = ois initialized.");

            while(!socket.isOutputShutdown()){
                if(br.ready()){

                    System.out.println("Client start writing in channel...");
                    String clientCommand = br.readLine();

                    oos.writeUTF(clientCommand);
                    oos.flush();
                    System.out.println("Client sent message " + clientCommand + " to server.");

                    if(clientCommand.equalsIgnoreCase("quit")){
                        System.out.println("Client kill connections");

                        if(ois.read() > -1)     {
                            System.out.println("reading...");
                            String in = ois.readUTF();
                            System.out.println(in);
                        }

                        break;
                    }

                    System.out.println("Client sent message & start waiting for data from server...");

//                    if(ois.read() > -1)     {
//
//                        System.out.println("reading...");
//                        String in = ois.readUTF();
//                        System.out.println(in);
//                    }
                }
            }

            System.out.println("Closing connections & channels on clientSide - DONE.");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
