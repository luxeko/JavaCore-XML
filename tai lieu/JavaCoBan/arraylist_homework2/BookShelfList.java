package arraylist_homework2;

import java.util.ArrayList;
import java.util.Scanner;
import arraylist_homework2.BookShelf;

public class BookShelfList {
	Scanner sc = new Scanner(System.in);
	private int vitrike;
//----------------------
//FIELD
	private ArrayList<BookShelf> BookShelfList = new ArrayList<BookShelf>();

//----------------------
//GETTER & SETTER
	public int getVitrike() {
		return vitrike;
	}
	public void setVitrike(int vitrike) {
		this.vitrike = vitrike;
	}

//----------------------
//METHOD
	// METHOD THEM KE SACH
	public void addKESACH() {
		System.out.print("NHAP VI TRI KE: ");
		int viTriKe = sc.nextInt();
		sc.nextLine();
		System.out.print("NHAP MA KE: ");
		String maKe = sc.nextLine();
		if (kiemtramake(maKe) == -1) {
			BookShelf shelf = new BookShelf(maKe, viTriKe);
			shelf.addSACHVAOKE();
			this.BookShelfList.add(shelf);
		} else {
			this.BookShelfList.get(kiemtramake(maKe)).addSACHVAOKE();
		}
	}

	// METHOD TIM THONG TIN CHUNG THEO MA SACH
	public void timthongtin(String keyword) {
		System.out.print("NHAP MA SACH: ");
		String maSach = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			if (this.BookShelfList.get(i).checkSach(maSach) != null) {
				flag = true;
				if (keyword.equalsIgnoreCase("timkiem")) {
					this.BookShelfList.get(i).checkSach(maSach).printSach();
				} else if (keyword.equalsIgnoreCase("xoa")) {
					this.BookShelfList.get(i).removeBook(this.BookShelfList.get(i).checkSach(maSach));
					System.out.println("THAO TAC THANH CONG");
				} else if (keyword.equalsIgnoreCase("timke")) {
					this.BookShelfList.get(i).timKe();
				}
			}
		}
		if (!flag) {
			System.out.println("SACH NAY KO TON TAI");
		}
	}

	// METHOD XUAT RA THONG TIN CUA CAC KE SACH
	public void printTTNHASACH() {
		System.out.println("THONG TIN NHA SACH");
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			this.BookShelfList.get(i).printTTKESACH();
		}
	}

	// METHOD KIEM TRA MA KE
	public int kiemtramake(String make) {
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			if (this.BookShelfList.get(i).getMaKe().compareTo(make) == 0) {
				return i;
			}
		}
		return -1;
	}

	// METHOD IN DANH SACH TRONG 1 KE SACH
	public void inSachKe() {
		System.out.print("NHAP MA KE: ");
		String make = sc.nextLine();
		if (this.kiemtramake(make) >= 0) {
			this.BookShelfList.get(this.kiemtramake(make)).xuatALLSACH();
		} else if (this.kiemtramake(make) == -1) {
			System.out.println("KE NAY CHUA TON TAI");
		}
	}

	// METHOD TIM KIEM SACH THEO CHU DE
	public void timKIEMSACHCD() {
		boolean flag = false;
		System.out.print("NHAP CHU DE CAN TIM KIEM: ");
		String chudeFind = sc.nextLine();
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			if (this.BookShelfList.get(i).checkCD(chudeFind).size() != 0) {
				flag = true;
				int length = this.BookShelfList.get(i).checkCD(chudeFind).size();
				for (int j = 0; j < length; j++) {
					this.BookShelfList.get(i).checkCD(chudeFind).get(j).printSach();
				}
			}
		}
		if (!flag) {
			System.out.println("CHU DE NAY KO TON TAI");
		}
	}

	// METHOD TIM KIEM SACH THEO TEN TAC GIA
	public void timKIEMSACHTG() {
		boolean flag = false;
		System.out.print("NHAP TEN TAC GIA CAN TIM KIEM: ");
		String tacgiafind = sc.nextLine();
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			if (this.BookShelfList.get(i).checkCD(tacgiafind).size() != 0) {
				flag = true;
				int length = this.BookShelfList.get(i).checkTG(tacgiafind).size();
				for (int j = 0; j < length; j++) {
					this.BookShelfList.get(i).checkTG(tacgiafind).get(j).printSach();
				}
			}
		}
		if (!flag) {
			System.out.println("TAC GIA NAY KO TON TAI");
		}
	}

	// METHOD SUA THONG TIN CUON SACH
	public void suaTTSach() {
		boolean flag = false;
		System.out.print("NHAP MA SACH CAN SUA THONG TIN: ");
		String masach = sc.nextLine();
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			if (this.BookShelfList.get(i).checkSach(masach) != null) {
				flag = true;
				this.BookShelfList.get(i).suaTT(this.BookShelfList.get(i).checkSach(masach));
			}
		}
		System.out.println(flag);
		if (!flag) {
			System.out.println("MA SACH NAY KO TON TAI");
		}
	}

	// METHOD TINH TONG SO SACH TRONG NHA SACH
	public int countSACHNS() {
		int sum = 0;
		for (int i = 0; i < this.BookShelfList.size(); i++) {
			sum += this.BookShelfList.get(i).lengShelf();
		}
		return sum;
	}

//----------Main------------------
	public static void main(String[] args) {
	}
}
