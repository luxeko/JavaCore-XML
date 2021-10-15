package java1.src.Buoi11;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String std = "32132021";
        Scanner sc = new Scanner(System.in);

        //ngoại lệ biên dịch
        try{
            //trong code try: dong code/ doan code kha nang se ngoai le
            Date d = sdf.parse(std);
        } //bat lay loi va xu ly no
        catch(ParseException e){
            e.printStackTrace();
        }
        
       
        //ngoại lệ runtime  
        String[] langs = {"Java", "C#"};
        System.out.println("Nhap 1 so: ");
        try{
            int num2 = Integer.parseInt(sc.nextLine()); 
            langs[3] = "php";
        } //catch(NullPointerException | InputMismatchException | ArrayIndexOutOfBoundsException e)
         catch (InputMismatchException e){
            System.out.println("Kieu du lieu dau vao khong dung");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Chỉ mục của phần tử mảng ko đúng");
        }catch(Exception e){
            //xu ly ngoai le, neu ngoai le sinh ra
            System.out.println("Chuoi thoi gian khong dung dinh dang");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally{
            //du vao try hay vao catch thi cuoi cung van phai chay vao finally
            System.out.println("Ket thuc nhap so");
        }

        //chi co gang chay ctrinh
        //ko bat va xu ly doi tuong ngoai le khi co loi xay ra
        try {
            langs[3] = "php";
        } finally {
            System.out.println("Vao finally");
        }

      
        //error: lỗi tài nguyên
        System.out.println("end");
        sc.close();
    }
}
