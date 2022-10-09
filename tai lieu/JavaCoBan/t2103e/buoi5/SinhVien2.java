package buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien2 {
	// 1. fields - thuộc tính: private
	// bien instance
	private String hoTen;
	private Date ngaySinh;
	private String maSv;
	private float diemToan;
	private float diemVan;
	private float diemAnh = -1;
	private String email;
	private LopHoc lopHoc;
	final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// methods
	// 2. constructor: public
	public SinhVien2() {
		super();
	}
	public SinhVien2(String hoTen, Date ngaySinh, String maSv, float diemToan, float diemVan, float diemAnh,
			String email, LopHoc lopHoc) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.maSv = maSv;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
		this.email = email;
		this.lopHoc = lopHoc;
	}
	public SinhVien2(String hoTen, String maSv) {
		super();
		this.hoTen = hoTen;
		this.maSv = maSv;
	}

	// 3. set (gán giá trị cho thuộc tính)/get: lấy giá trị của thuộc tính: public
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public float getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	public float getDiemVan() {
		return diemVan;
	}
	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}
	public float getDiemAnh() {
		return diemAnh;
	}
	public void setDiemAnh(float diemAnh) {
		this.diemAnh = diemAnh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LopHoc getLopHoc() {
		return lopHoc;
	}
	// 4. method nghiệp vụ: public
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten: ");
		this.hoTen = sc.nextLine();
		do {
			System.out.println("Nhap ngay sinh: ");
			String sdate = sc.nextLine();
			
			// su dung sdf de chuyen doi string sang Date
			try {
				this.ngaySinh = sdf.parse(sdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(this.ngaySinh == null);
		
		while(true) {
			System.out.println("Nhap masv: ");
			// sv0001, 11122, 11122223333, 111
			this.maSv = sc.nextLine();
			// dk thoat lap:
			if (this.maSv.length() == 5) {
				break;
			} else {
				System.out.println("Ma sv khong dung 5 ky tu.");
			}
		}
		do {
			System.out.println("Nhap diem Toan: ");
			this.diemToan = sc.nextFloat();
		}while(this.diemToan < 0 || this.diemToan > 10);
		
		while(true) {
			System.out.println("Nhap diem Van: ");
			this.diemVan = sc.nextFloat();
			if (this.diemVan >= 0 && this.diemVan <= 10) {
				break;
			}
		}
		while (this.diemAnh == -1) {
			System.out.println("Nhap diem Anh: ");
			this.diemAnh = sc.nextFloat();
			if (this.diemAnh < 0 || this.diemAnh > 10) {
				this.diemAnh = -1;
			}
		}
		System.out.println("Nhap thong tin lop hoc: ");
		this.lopHoc = new LopHoc();
		this.lopHoc.nhap();
	}
	public void xuat() {
		System.out.println("-------Thong tin sv-----");
		System.out.println("Ho ten: "+ this.hoTen);
		System.out.println("Ngay sinh: "+ sdf.format(this.ngaySinh));
		System.out.println("Ma sv: "+ this.maSv);
		System.out.println("Diem toan: "+ this.diemToan);
		System.out.println("Diem Van: "+ this.diemVan);
		System.out.println("Diem Anh: "+ this.diemAnh);
		System.out.println("Diem TB: "+ this.tinhDiemTB() 
						+ "; Hoc luc: "+ this.tinhHocLuc());
		System.out.println("Lop hoc: "+ this.lopHoc.xuat());
	}
	public float tinhDiemTB() {
		return (this.diemToan + this.diemVan + this.diemAnh)/3;
	}
	public String tinhHocLuc() {
		float diemtb = this.tinhDiemTB();
		if (diemtb < 4) {
			return "Yeu";
		} else if (diemtb < 7) {
			return "TB";
		} else if (diemtb < 8.5) {
			return "Kha";
		} else {
			return "Gioi";
		}
	}
}
