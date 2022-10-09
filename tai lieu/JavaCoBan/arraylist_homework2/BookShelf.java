package arraylist_homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import arraylist_homework2.Book;

public class BookShelf {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
//----------------------
//FIELD
	private String maKe;
	private int viTriKe;
	private int vitriketim;
	private boolean isShelf = false;
	private ArrayList<Book> ShelfBook = new ArrayList<Book>();

//----------------------
//GETTER & SETTER
	public String getMaKe() {
		return maKe;
	}

	public int getViTriKeTim() {
		return vitriketim;
	}

	public boolean isShelf() {
		return isShelf;
	}

	public void setShelf(boolean isShelf) {
		this.isShelf = isShelf;
	}

	public void setViTriKeTim(int vitriketim) {
		this.vitriketim = vitriketim;
	}

	public void setMaKe(String maKe) {
		this.maKe = maKe;
	}

	public int getViTriKe() {
		return viTriKe;
	}

	public void setViTriKe(int viTriKe) {
		this.viTriKe = viTriKe;
	}

	public ArrayList<Book> getShelfBook() {
		return ShelfBook;
	}

	public void setShelfBook(ArrayList<Book> shelfBook) {
		ShelfBook = shelfBook;
	}

	// ----------------------
//CONTRUCTOR
	public BookShelf(String maKe, int viTriKe) {
		this.maKe = maKe;
		this.viTriKe = viTriKe;
	}

//----------------------
//METHOD
	// METHOD THEM SACH VAO KE
	public void addSACHVAOKE() {
		Book newBook = new Book();
		newBook.addSach();
		this.ShelfBook.add(newBook);
	}

	// METHOD XUAT THONG TIN KE SACH
	public void printTTKESACH() {
		System.out.println("---------------------------");
		System.out.println("THONG TIN KE " + this.maKe);
		System.out.println("VI TRI KE: " + this.viTriKe);
		System.out.println("TONG SO SACH TAI KE " + this.maKe + " LA " + this.ShelfBook.size());
	}

	// METHOD TIM THONG TIN KE SACH THEO MA SACH
	public void timKe() {
		System.out.println("CUON SACH NAY NAM TAI KE: " + this.maKe + " TAI VI TRI: " + this.viTriKe);
	}

	// METHOD XOA SACH RA KHOI KE
	public void xoaSach(int index) {
		this.ShelfBook.remove(index);
		System.out.println("THAO TAC THANH CONG");
	}

	// METHOD XUAT THONG TIN CAC CUON SACH
	public void xuatALLSACH() {
		for (int i = 0; i < this.ShelfBook.size(); i++) {
			this.ShelfBook.get(i).printSach();
		}
	}

	// METHOD KIEM TRA 1 CUON SACH CO TON TAI KHONG
	public Book checkSach(String masach) {
		for (int j = 0; j < this.ShelfBook.size(); j++) {
			if (this.ShelfBook.get(j).getMaSach().equals(masach)) {
				return this.ShelfBook.get(j);
			}
		}
		return null;
	}

	// METHOD XOA SACH
	public void removeBook(Book book) {
		int index = this.ShelfBook.indexOf(book);
		this.ShelfBook.remove(index);
	}

	// METHOD CHECK CHU DE
	public ArrayList<arraylist_homework2.Book> checkCD(String tenchude) {
		ArrayList<Book> newShelf = new ArrayList<Book>();
		for (int i = 0; i < this.ShelfBook.size(); i++) {
			if (this.ShelfBook.get(i).getChude().equals(tenchude)) {
				newShelf.add(this.ShelfBook.get(i));
			}
		}
		return newShelf;
	}

	// METHOD CHECK TAC GIA
	public ArrayList<arraylist_homework2.Book> checkTG(String tentacgia) {
		ArrayList<Book> newShelf = new ArrayList<Book>();
		for (int i = 0; i < this.ShelfBook.size(); i++) {
			if (this.ShelfBook.get(i).getTacGia().equals(tentacgia)) {
				newShelf.add(this.ShelfBook.get(i));
			}
		}
		return newShelf;
	}

	// METHOD TIM TONG SO SACH TRONG MOI SHELF
	public int lengShelf() {
		return this.ShelfBook.size();
	}

	// METHOD SUA TT 1 CUON SACH
	public void suaTT(Book book) {
		String confirm = "";
		int index = this.ShelfBook.indexOf(book);
		do {
			System.out.println("CHON FIELD CAN SUA THONG TIN");
			System.out.println("1 SUA MA SACH");
			System.out.println("2 SUA TEN SACH");
			System.out.println("3 SUA GIA SACH");
			System.out.println("4 SUA CHU DE");
			System.out.println("5 SUA NGAY XUAT BAN");
			System.out.println("6 SUA TEN TAC GIA");
			System.out.println("7 THOAT");
			System.out.print("NHAP LUA CHON: ");
			int choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.print("NHAP MA SACH MOI: ");
				String newMS = sc.nextLine();
				this.ShelfBook.get(index).setMaSach(newMS);
				break;
			case 2:
				System.out.print("NHAP TEN SACH MOI: ");
				String newTS = sc.nextLine();
				this.ShelfBook.get(index).setTenSach(newTS);
				break;
			case 3:
				System.out.print("NHAP GIA SACH MOI: ");
				float newGS = sc.nextFloat();
				this.ShelfBook.get(index).setGiaSach(newGS);
				break;
			case 4:
				System.out.print("NHAP CHU DE SACH: ");
				String newCD = sc.nextLine();
				this.ShelfBook.get(index).setChude(newCD);
				break;
			case 5:
				System.out.print("SUA NGAY XUAT BAN");
				String sdate = sc.nextLine();
				try {
					this.ShelfBook.get(index).setNgayxuatban(formatDate.parse(sdate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.print("SUA TEN TAC GIA: ");
				String newtg = sc.nextLine();
				this.ShelfBook.get(index).setTacGia(newtg);
				break;
			case 7:
				System.out.println("BAN VUI LONG CHI CHON THEO OPTION TREN!");
				break;
			}
			// DK TIEP TUC CHUONG TRINH
			System.out.print("BAN CO MUON TIEP TUC SUA FIELD NAO KHONG (n:THOAT)");
			confirm = sc.nextLine();
		} while (!confirm.equalsIgnoreCase("n"));
	}

//--------Main-----------
	public static void main(String[] args) {
	}

}
