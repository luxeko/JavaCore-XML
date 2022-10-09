package buoi11;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowDemo {
	private ArrayList<String[]> listValidBook = new ArrayList<String[]>();
	public static void main(String[] args) {
		System.out.println("Step 1");
		
		try {
			ThrowDemo.validateCheckedException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileLockInterruptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			ThrowDemo.validateUnCheckedException(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		System.out.println("Step End");
	}
	// doc file
	// throws: khai bao cac loai ngoai le co kha nang xay ra khi ham runtime
	public static void validateCheckedException() throws FileNotFoundException, FileLockInterruptionException {
		//File file = new File("D:\\WORK\\fpt\\T2103Ewsp\\T2103E_java1\\dsbook.txt");
		File file = new File("dsbook.txt");
		Scanner sc = new Scanner(file);
		// doc file
		while(sc.hasNext()) {
			String line = sc.nextLine();
			try {
				validateUnCheckedException(line);
				System.out.println(line + " -> ok");
			}catch(Exception e) {
				System.out.println(line + " -> NOT ok: "+ e.getMessage());
			}
		}
		System.out.println("OK");
	}
	// validate 1 hang du lieu tuong ung voi 1 quyen sach
	// b001,Cuon theo chieu gio,120000,Dungpt
	// mang 4 phan tu, phan tu th3: gia phai la so nguyen duong
	public static void validateUnCheckedException(String input){
		/*
		 * - du lieu dau vao
		 * - chuyen doi kieu: parse, format
		 * - ep kieu: cast
		 * - index: array, collection
		 * - null
		 * */
		// check validate sodienthoai
		// throw: nem 1 doi tuong ngoai cu the ra chuong trinh
		if (input == null) {
			throw new NullPointerException("Input is empty");
		}
		String[] arr = input.split(",");
		if (arr.length == 4) {
			// du lieu tam ok
			String s_price = arr[2];
			try {
				long price = Long.parseLong(s_price);
			}catch(Exception e) {
				throw new InputMismatchException("Price is not number");
			}
		} else {
			throw new ArrayIndexOutOfBoundsException("Input is not enough");
		}
	}
}
