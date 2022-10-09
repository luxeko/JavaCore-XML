package arraylist_homework2;

import java.util.Scanner;
import arraylist_homework2.BookShelfList;

public class BookManage {

	public static void main(String[] args) {
		// ADD
		Scanner sc = new Scanner(System.in);
		// VARIABLES
		BookShelfList bookstore = new BookShelfList();
		String confirm = "";
		boolean flag = true;

		// BEGIN
		do {
			System.out.println("CHUONG TRINH QUAN LY HIEU SACH");
			System.out.println("------------------------------");
			System.out.println("1 THEM 1 QUYEN SACH VAO TRONG HIEU SACH THEO MA KE");
			System.out.println("2 XOA 1 QUYEN SACH RA KHOI HIEU SACH THEO MA SACH");
			System.out.println("3 HIEN THI THONG TIN KE SACH THEO MA SACH");
			System.out.println("4 HIEN THI THONG TIN CUA NHA SACH: KE SACH, VI TRI KE, SO LUONG SACH");
			System.out.println("5 SUA LAI THONG TIN QUYEN SACH THEO MA SACH");
			System.out.println("6 TIM KIEM THONG TIN 1 QUYEN SACH THEO MA SACH");
			System.out.println("7 HIEN THI DANH SACH CAC QUYEN SACH TRONG 1 KE SACH");
			System.out.println("8 HIEN THI SACH THEO CHU DE DO NGUOI DUNG NHAP VAO");
			System.out.println("9 HIEN THI SACH THEO TEN TAC GIA MA NGUOI DUNG NHAP VAO");
			System.out.println("10 IN TONG SO SACH HIEN CO");
			System.out.println("11 THOAT");
			System.out.print("NHAP LUA CHON: ");
			int choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("CHON KE SACH MUON THEM");
				bookstore.addKESACH();
				break;
			case 2:
				bookstore.timthongtin("xoa");
				break;
			case 3:
				System.out.println("HIEN THI THONG TIN KE SACH THEO MA SACH");
				bookstore.timthongtin("timke");
				break;
			case 4:
				bookstore.printTTNHASACH();
				break;
			case 5:
				bookstore.suaTTSach();
				break;
			case 6:
				System.out.println("TIM KIEM THONG TIN MOT CUON SACH");
				bookstore.timthongtin("timkiem");
				break;
			case 7:
				System.out.println("XEM DANH SACH SACH TRONG KE");
				bookstore.inSachKe();
				break;
			case 8:
				System.out.println("TIM KIEM SACH THEO CHU DE");
				bookstore.timKIEMSACHCD();
				break;
			case 9:
				System.out.println("TIM KIEM SACH THEO TEN TAC GIA");
				bookstore.timKIEMSACHTG();
				break;
			case 10:
				System.out.println("TONG SO SACH HIEN CO TAI HIEU SACH LA: " + bookstore.countSACHNS());
				break;
			case 11:
				System.out.println("CAM ON BAN!");
				flag = false;
				break;
			default:
				System.out.println("VUI LONG CHON DUNG THEO LIST MENU CUNG CAP");
				break;
			}
			// DK THOAT KHOI CHUONG TRINH
			if (flag) {
				System.out.print("BAN CO MUON TIEP TUP CHUONG TRINH (n:THOAT): ");
				confirm = sc.nextLine();
			}
		} while (!confirm.equalsIgnoreCase("n") && flag);
	}
}
