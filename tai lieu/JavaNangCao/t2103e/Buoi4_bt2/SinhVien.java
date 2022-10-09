package Buoi4_bt2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SinhVien {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	//---------------------
	//FIELD
	private String maSV;
	private String tenSV;
	private Date ngaySinh;
	private String phone;
	private String email;
	private String diachi;
	private String gioitinh;
	private String maKhoa;
	
	
	

	public SinhVien(String maSV, String tenSV, Date ngaySinh, String phone, String email, String diachi,
			String gioitinh, String maKhoa) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.ngaySinh = ngaySinh;
		this.phone = phone;
		this.email = email;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.maKhoa = maKhoa;
	}
	public SinhVien() {
		
	}
	//---------------------
	//SETTER & GETTER
	public String getMaKhoa() {
		return maKhoa;
	}
	
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	//---------------------
	//METHOD
	
	//METHOD NHAP THONG TIN SINH VIEN
	public void addInfoSV() {
		
		//MA SINH VIEN FIELD
		while(true) {
			System.out.print("NHAP MA SINH VIEN: ");
			this.maSV = sc.nextLine();
			if(this.maSV.length() == 4) {
				break;
			}else {
				System.out.println("VUI LONG NHAP MA SINH VIEN CO 4 KY TU");
			}
		}
		//MA SINH VIEN FIELD
				while(true) {
					System.out.print("NHAP MA KHOA: ");
					this.maKhoa = sc.nextLine();
					if(this.maKhoa.length() == 4) {
						break;
					}else {
						System.out.println("VUI LONG NHAP MA KHOA CO 4 KY TU");
					}
				}
		//TEN SINH VIEN FIELD
		while(true){
			System.out.print("NHAP TEN SINH VIEN: ");
			this.tenSV = sc.nextLine();
			if(this.tenSV.length() > 10) {
				break;
			}else {
				System.out.println("VUI LONG NHAP HO TEN LON HON 10 KY TU");
			}
		}
		//NGAY SINH FIELD
		do {
			System.out.print("NHAP NGAY SINH: ");
			String date = sc.nextLine();
			try {
				this.ngaySinh = formatDate.parse(date);
			} catch (ParseException e) {
				System.out.println("VUI LONG NHAP NGAY SINH THEO DINH DANG dd/MM/yyyy");
			}
		}while(this.ngaySinh == null);
		//PHONE FIELD
		while(true) {
			System.out.print("NHAP SO DIEN THOAI: ");
			this.phone = sc.nextLine();
			if(this.phone.length() == 10 && this.phone.startsWith("09")) {
				break;
			}else {
				System.out.println("VUI LONG NHAP SO DIEN THOAI CO 10 KY TU VA BAT DAU BANG 09");
			}
		}
		//EMAIL FIELD
		while(true) {
			System.out.print("NHAP EMAIL: ");
			this.email = sc.nextLine();
			if(this.email.length() > 10 && this.email.contains("@")) {
				break;
			}else {
				System.out.println("VUI LONG NHAP EMAIL CO 10 KY TU TRO LEN VA CHUA KY TU @");
			}
		}
		//DIA CHI FIELD
		while(true) {
			System.out.print("NHAP DIA CHI: ");
			this.diachi = sc.nextLine();
			if(this.diachi == null) {
				System.out.println("VUI LONG KHONG DE TRONG DIA CHI");
			}else {
				break;
			}
		}
		//GIOI TINH FIELD
		while(true) {
			System.out.print("NHAP GIOI TINH(1:NAM 0:NU): ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				if(choose ==  1) {
					this.gioitinh = "NAM";
					break;
				}else if(choose == 0) {
					this.gioitinh = "NU";
					break;
				}else {
					System.out.println("VUI LONG CHI NHAP 1 HOAC 0");
				}
			}catch(InputMismatchException e) {
				System.out.println("VUI LONG NHAP DINH DANG SO");
			}
		}
	}
}
