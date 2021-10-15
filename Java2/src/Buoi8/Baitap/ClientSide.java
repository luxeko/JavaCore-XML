package Java2.src.Buoi8.Baitap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.Scanner;

public class ClientSide {

    public static void main(String[] args) throws IOException {
        System.out.println("Client start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Lay thong tin lien quan den ip: localhosst
        //InetAddress myIp = InetAddress.getByName("192.168.0.2");
        //Tao 1 doi tuong quan ly ket noi voi server
        Socket client = new Socket("127.0.0.1",8888);
        System.out.println("Client connected");
        
        // 1. client gui chuoi du lieu cho server -> client: write/output
        // 1. server nhan du lieu tu client gui -> server : read/input
        // 2. server gui du lieu cho client -> server: write/output
        // 2. client nhan du lieu tu server gui -> client: read/input
        try (
            //lay stream input - read tu kenh ket noi giua client va server
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            //lay stream output - write tu kenh ket noi giua client va server
            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            Scanner sc = new Scanner(System.in)
            ){
            while(true){
                // 1. client gui chuoi du lieu cho server -> client: write/output
                System.out.println("Client says: ");
                String str = sc.nextLine();
                pw.write(str);
                // day du lieu tu stream xuong dich
                pw.flush();

                // 2. client nhan du lieu tu server gui -> client: read/input

                
                char[] chs = new char[1024];
                int read = br.read(chs);
                if(read > -1){
                    String receiver = new String(chs);
                    System.out.println("Receiver from Server: " + receiver.trim());
                    if(receiver.startsWith("Bye")){
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        client.close();

        System.out.println("Client end!");
    }
}
