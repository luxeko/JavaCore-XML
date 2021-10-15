package Java2.src.Buoi8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {

    public static void main(String[] args) throws IOException {
        System.out.println("Server start");
        //tao ra 1 doi tuong quan ly cac socket dai dien cho ung dung
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server connecting...");

        //khi co yeu cau tu client len, server chap nhan -> tao 1 socket phuc vu rieng socket client
        Socket server = serverSocket.accept();
        System.out.println("Server connected");
        try (
            //stream read
            BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream(), "UTF-8"));

            //stream write
            PrintWriter pw = new PrintWriter(server.getOutputStream());
            Scanner sc = new Scanner(System.in)
        ){
            while(true){
                 // 1. server nhan du lieu tu client gui -> server : read/input
                char[] chs = new char[1024];
                int read = br.read(chs);
                if(read > -1){
                    String receiver = new String(chs);
                    System.out.println("Receiver from Client: " + receiver);
                }
                // 2. server gui du lieu cho client -> server: write/output
                System.out.println("Server says: ");
                String sender = sc.nextLine();
                pw.write(sender);
                pw.flush();
            }
           
        } catch (Exception e) {
           e.printStackTrace();
        }
        serverSocket.close();
        
        System.out.println("Server end!");
    }
}
