package arraylist_homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

//--------------------
//FIELD
	private String maSach;
	private String tenSach;
	private float giaSach;
	private String chude;
	private String tacGia;
	private Date ngayxuatban;

//---------------------
//SETTER & GETTER
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public float getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(float giaSach) {
		this.giaSach = giaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getChude() {
		return chude;
	}

	public void setChude(String chude) {
		this.chude = chude;
	}

	public Date getNgayxuatban() {
		return ngayxuatban;
	}

	public void setNgayxuatban(Date ngayxuatban) {
		this.ngayxuatban = ngayxuatban;
	}

//---------------------
//METHOD
	// METHOD THEM THONG TIN 1 QUYEN SACH
	public void addSach() {
		System.out.println("NHAP THONG TIN SACH");
		System.out.print("NHAP MA SACH: ");
		this.maSach = sc.nextLine();
		System.out.print("NHAP TEN SACH: ");
		this.tenSach = sc.nextLine();
		System.out.print("NHAP CHU DE SACH: ");
		this.chude = sc.nextLine();
		System.out.print("NHAP GIA SACH: ");
		this.giaSach = sc.nextFloat();
		sc.nextLine();
		System.out.print("NHAP TEN TAC GIA: ");
		this.tacGia = sc.nextLine();
		do {
			System.out.print("NHAP NGAY XUAT BAN: ");
			String sdate = sc.nextLine();
			try {
				this.ngayxuatban = formatDate.parse(sdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (this.ngayxuatban == null);
	}

	// METHOD XUAT THONG TIN 1 QUYEN SACH
	public void printSach() {
		System.out.println("THONG TIN SACH");
		System.out.println("--------------");
		System.out.println("TEN CUON SACH: " + this.tenSach);
		System.out.println("MA CUON SACH: " + this.maSach);
		System.out.println("GIA SACH: " + this.giaSach);
		System.out.println("CHU DE SACH: " + this.chude);
		System.out.println("NGAY XUAT BAN: " + this.ngayxuatban);
	}

//-----Main---------
	public static void main(String[] args) {
	}
}
