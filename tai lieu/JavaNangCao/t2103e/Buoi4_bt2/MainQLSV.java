package Buoi4_bt2;

import java.io.File;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MainQLSV {
	public static String root = System.getProperty("user.dir");
	public static File fileRoot = new File(root);
	public static Set<File> listFileStore = new LinkedHashSet<File>();
	public static File folderInputed = new File("D:\\Java_workspace\\Java2_BaiTap\\FileInputed");

	public static void main(String[] args) {
		SINHVIENDAO.travserFile(fileRoot);
		Scanner sc = new Scanner(System.in);
		String confirm = "";
		boolean flag = true;
		do {
			System.out.println("CHUONG TRINH QUAN LY SINH VIEN");
			System.out.println("------------------------------");
			System.out.println("1: CRUD SINH VIEN");
			System.out.println("2: CRUD KHOA");
			System.out.println("3: CRUD MON HOC");
			System.out.println("4: CRUD BAO CAO");
			System.out.println("5: THOAT!");
			System.out.print("NHAP LUA CHON: ");
			try {
				int choose = sc.nextInt();	
				sc.nextLine();
				switch (choose) {
				case 1:
					SINHVIENDAO.menuSV();
					break;
				case 2:
					KHAODAO.menuKHOA();
					break;
				case 3:
					MONHOCDAO.menuMonHoc();
					break;
				case 4:
					KETQUADAO.menuKetQua();
					break;
				case 5:
					System.out.println("CAM ON BAN!");
					flag = false;
					break;
				default:
					System.out.println("VUI LONG NHAP THEO MENU");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("VUI LONG NHAP MENU DANG SO " + e.getMessage());
			}
			if (flag) {
				System.out.print("BAN CO MUON TIEP TUC CHUONG TRINH(n:THOAT!): ");
				confirm = sc.nextLine();
			}
		} while (!confirm.equalsIgnoreCase("n") && flag);
	}

}
