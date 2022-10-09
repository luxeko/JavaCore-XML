package buoi11;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String std = "32132021";
		Scanner sc = new Scanner(System.in);
		
		// ngoại lệ biên dịch
			// trong code try: dong code/ doan code kha nang sẽ ngoai le
			
		try {
			Date d =  sdf.parse(std);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		String[] langs = {"java", "c#"};
		// ngoại lệ runtime
		System.out.println("Nhap 1 so: ");
		try {
			int num2 = sc.nextInt();
			langs[3] = "php";
		} 
		// bat lay loi va xu ly no
		catch (InputMismatchException e) {
			System.out.println("Kieu du lieu dau vao khong dung");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Chỉ muc cua phan tu mang khong dung.");
		}
		catch(Exception  e) {
			// xu ly ngoai le, neu ngoai le sinh ra
			System.out.println("Chuoi thoi gian khong dung dinh dang.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// du vao try hay vao catch thi cuoi cung van phai chay voa finally
			System.out.println("Ket thuc nhap so.");
		}
		// chi co gang chay ctrinh
		// khong bat va xu ly doi tuong ngoai le khi co loi xay ra
		try {
			langs[3] = "php";
		}finally {
			System.out.println("Vao finally");
		}
		// error: lỗi tài nguyên
		System.out.println("end");
	}

}
