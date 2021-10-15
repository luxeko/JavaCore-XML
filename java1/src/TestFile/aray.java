package java1.src.TestFile;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;


public class aray {
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap ngay bat dau: ");
//        String start_date = sc.nextLine();
        System.out.print("Nhap ngay ket thuc: ");
        String end_date = sc.nextLine();

        try {
//            Date d1 = sdf.parse(start_date);
            Date d1 = new Date(System.currentTimeMillis());
            Date d2 = sdf.parse(end_date);

            long difference_In_Time = d2.getTime() - d1.getTime();

            long difference_In_Days = difference_In_Time / (1000 * 60 * 60 * 24);

            System.out.println(difference_In_Time + "\n" + difference_In_Days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}