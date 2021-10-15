package java1.src.Buoi11.BTVN.Bai2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SinhVien {

    public void readFile() {
        try {
            // Đọc file theo đường dẫn
            File file = new File("E:\\Java\\Buoi3\\dsSinhVien.txt");
    
            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // Đọc từng dòng của file và tiến hành cộng tổng lại
            FileReader fr = new FileReader(file);
            LineNumberReader lnr = new LineNumberReader(fr);
            int linenumber = 0;
            while (lnr.readLine() != null) {
                linenumber++;
            }
            System.out.println("Số sinh viên: " + linenumber);
            lnr.close();
            
            // Hiển thị ra màn hình tổng các số nguyên trong file
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
    public static void printInfo() throws FileNotFoundException{
        File file = new File("E:\\Java\\Buoi3\\dsSinhVien.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String line = sc.nextLine();
            try {
                UnCheckedException(line);
                System.out.println(line);
            } catch (Exception e) {
                System.out.println(line + e.getMessage());
            }
        }sc.close();
    }
    public static void UnCheckedException(String input){
        String[] arr = input.split(", ");
        if(arr.length == 5){
            //du lieu tam ok
            String s_score = arr[3];
            try{
                Long score = Long.parseLong(s_score);
            }catch(Exception e){
                throw new InputMismatchException("Score is not number");
            }
        }else{
            //du lieu sai hoac thieu
            throw new ArrayIndexOutOfBoundsException("Dữ liệu ko đủ");
        }   
    }
   
}

