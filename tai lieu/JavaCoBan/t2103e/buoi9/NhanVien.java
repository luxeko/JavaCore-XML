package buoi9;
import java.util.Scanner;

import buoi8.Nguoi;
public abstract class NhanVien extends Nguoi{
	// dn đặc điểm hanh vi riêng của NV
	private String manv;
	private String viTriLv;
	
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getViTriLv() {
		return viTriLv;
	}
	public void setViTriLv(String viTriLv) {
		this.viTriLv = viTriLv;
	}
	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap manv: ");
		this.manv = sc.nextLine();
		
		System.out.println("Nhap vi tri lv: ");
		this.viTriLv = sc.nextLine();
	}
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println("Ma nv: "+ this.manv);
		System.out.println("Vi tri Lv: "+ this.viTriLv);
	}
	// hàm trừu tượng: hàm chỉ khai báo và không có thân hàm.
	public abstract long tinhLuong();
	public abstract float tinhCong();
	
}
