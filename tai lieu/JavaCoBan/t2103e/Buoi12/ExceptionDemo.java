package buoi1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import  java.text.Format ;

public class ExceptionDemo {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date ngaysnbac = sdf.parse("19/05/1890");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// try with resource:
		// - doi tuong stream se duoc tu dong giai phong khi thuc hien xong khoi try
		// - code ngan gon hon
		File file = new File("sinhvien.txt");
		// ghi file
		// b1: tao ket noi toi file vat ly
		try (FileWriter fw = new FileWriter(file, true)){
			// b2: ghi file
			fw.write("buoi 1: Ngoai le \n");
			String s = null;
			if (s != null)
				fw.write(s);
			
			fw.write("buoi2: collection\n");
		}catch(Exception e) {
			System.out.println("Thuc thi ghi file bi loi: "+ e.getMessage());
		}
		System.out.println("Ghi file xong!");
		// doc file
		// b1: tao ket noi toi file
		try (
				// khoi code khoi tao doi tuong co ham close (implement Closeable | AutoCloseable)
				Scanner sc = new Scanner(file);
			){
			// doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
		}catch(Exception e) {
			System.out.println("Loi doc file: "+ e.getMessage());
		}
	}
	public static void main_try(String[] args) {
		File file = new File("sinhvien.txt");
		// ghi file
		// b1: tao ket noi toi file vat ly
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			// b2: ghi file
			fw.write("buoi 1: Ngoai le \n");
			String s = null;
			if (s != null)
				fw.write(s);
			
			fw.write("buoi2: collection\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			// b3: giai phong ket noi toi file vat ly
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		System.out.println("Ket thuc ghi file !");
		// doc file
		Scanner sc = null;
		try {
			// b1: tao ket noi toi file vat ly
			sc = new Scanner(file);
			// b2: doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			
		}catch(IOException e) {
			System.out.println("File khong ton tai.");
		}
		// b3: giai phong ket noi toi file
		/*
		finally {
			if (sc != null) {
				sc.close();
			}
		}
		*/
		System.out.println("Doc xong file!");
	}

}
