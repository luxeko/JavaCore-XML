package Java2.src.Buoi2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args)  {
        File file = new File("sinhvien.txt");

        // Ghi file
        //b1: tạo kết nối tới file vật lý
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write("Buoi1: Ngoai le \n");
            String s ="";
            if( s !=null){
                fw.write(s);
            }
            fw.write("Buoi2: collection \n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        finally { 
             //b3: Giải phóng kết nối tới file vật lý
            if(fw != null){
                  try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Kết thúc ghi file");

        // Đọc file
        Scanner sc = null;
        try {
            //b1: tạo kết nối tới file vật lý
            sc = new Scanner(file);
            while(sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File ko tồn tại!");
        }finally{
            //b3: Giải phóng kết nối tới file vật lý
            if(sc != null){
                 sc.close();
            }
        }
        System.out.println("Đọc xong file!");
      
    }
}
