package Java2.src.Buoi7.BTVN.Bai1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ThreadDocFile {
    public static void main(String[] args) {
        ThreadOne thread1 = new ThreadOne("thread 1");
        thread1.start();
    }
}
class ThreadOne extends Thread {
    private String nameThread;
    public ThreadOne(String nameThread){
        this.nameThread = nameThread;
    }

    @Override
    public void run() {
        int length;
        File goc = new File("E://Java//Java2//src//Buoi7//BTVN//Bai1//thucmucgoc//abcd.txt");
        InputStream inStream = null;
        OutputStream outStream = null;
 
        try {
            inStream = new FileInputStream(goc);
            outStream = new FileOutputStream(new File("E://Java//Java2//src//Buoi7//BTVN//Bai1//thucmucbk//abcd.txt"));
            
            FileReader fr = new FileReader(goc);
            BufferedReader br = new BufferedReader(fr);
            String line;
            byte[] buffer = new byte[1024];
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            // copy the file 
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
                
            }
            System.out.println("sao chép thành công!");
            fr.close();
            br.close();
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



