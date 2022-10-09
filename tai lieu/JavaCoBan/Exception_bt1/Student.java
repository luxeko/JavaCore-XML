package Exception_bt1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	// ----------------------
	// FIELD
	private String maSv;
	private String hoTen;
	private Date ngaySinh;
	private float diem;
	private String xepLoai;

	// ----------------------
	// CONTRUCTOR
	public Student(String maSv, String hoTen, Date ngaySinh, float diem, String xepLoai) {
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diem = diem;
		this.xepLoai = xepLoai;
	}

	public Student() {

	}

	// ----------------------
	// SETTER & GETTER
	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai() {
		String xeploaihs = "";
		if (this.diem < 5.0) {
			xeploaihs = "KEM";
		} else if (this.diem < 7) {
			xeploaihs = "TRUNG BINH";
		} else if (this.diem < 9) {
			System.out.print("CHECK");
			xeploaihs = "KHA";
		} else if (this.diem >= 9) {
			System.out.print("CHECK");
			xeploaihs = "GIOI";
		}
		this.xepLoai = xeploaihs;
	}

	// ----------------------
	// METHOD

	// METHOD NHAP THONG TIN SINH VIEN
	public void nhapTT() {
		System.out.println("NHAP THONG TIN SINH VIEN");
		System.out.print("NHAP MA SINH VIEN: ");
		this.maSv = sc.nextLine();
		System.out.print("NHAP HO TEN: ");
		this.hoTen = sc.nextLine();

		// NGAY SINH FIELD
		do {
			System.out.print("NHAP NGAY SINH: ");
			String s_date = sc.nextLine();
			try {
				this.ngaySinh = formatDate.parse(s_date);
			} catch (ParseException e) {
				System.out.println("NGAY SINH KHONG DUNG DINH DANG");
			}
		} while (this.ngaySinh == null);

		// DIEM FIELD
		do {
			System.out.print("NHAP DIEM: ");
			try {
				this.diem = sc.nextFloat();
			} catch (NullPointerException e) {
				System.out.println("DIEM KHONG DUOC DE TRONG");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("DIEM KHONG DUNG DINH DANG");

			}
		} while (this.diem < 0 || this.diem > 10);
		this.setXepLoai();
	}

	// METHOD XUAT THONG TIN SINH VIEN
	public void xuatTT() {
		System.out.println("THONG TIN SINH VIEN");
		System.out.println("HO TEN SINH VIEN :" + this.hoTen);
		System.out.println("MA SINH VIEN: " + this.maSv);
		System.out.println("NGAY SINH: " + formatDate.format(ngaySinh));
		System.out.println("DIEM :" + this.diem);
		System.out.println("XEP LOAI: " + this.xepLoai);
		this.timngaysinhnhat();
	}

	public void timngaysinhnhat() {
		Scanner sc = new Scanner(System.in);
		String ngaysinh = formatDate.format(ngaySinh).toString();
		ngaysinh = ngaysinh.substring(0, 5);
		System.out.println(ngaysinh);
		Date ngaysinh_cov;
		Date today;
		LocalDate myday = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter mymonth = DateTimeFormatter.ofPattern("MM");
		DateTimeFormatter myyear = DateTimeFormatter.ofPattern("yyyy");
		String formattedDate = myday.format(myFormatObj);
		String formattedMonth = myday.format(mymonth);
		String formattedYear = myday.format(myyear);
		if (Integer.parseInt(ngaysinh.substring(3, 5)) > Integer.parseInt(formattedMonth)) {
			ngaysinh = ngaysinh + "/" + formattedYear;
		} else {
			ngaysinh = ngaysinh + "/" + String.valueOf((Integer.parseInt(formattedYear) + 1));
		}
		try {
			ngaysinh_cov = formatDate.parse(ngaysinh);
			today = formatDate.parse(formattedDate);
			long difference = Math.abs(today.getTime() - ngaysinh_cov.getTime());
			long differenceDates = difference / (24 * 60 * 60 * 1000);

			String dayDifference = Long.toString(differenceDates);
			System.out.println("CON " + dayDifference + " DEN NGAY SINH NHAT CUA BAN ");
		} catch (ParseException e) {
			System.out.println("VUI LONG NHAP THEO DINH DANG NGAY");
		}
	}

	public static void main(String[] args) {
		Student newStudent = new Student();
		newStudent.nhapTT();
		newStudent.xuatTT();

	}
}
