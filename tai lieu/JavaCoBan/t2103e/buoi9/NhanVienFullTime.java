package buoi9;

import java.util.Scanner;

public class NhanVienFullTime extends NhanVien {
	private float hsLuongBh;
	private float hsLuongCb;
	
	public float getHsLuongBh() {
		return hsLuongBh;
	}

	public void setHsLuongBh(float hsLuongBh) {
		this.hsLuongBh = hsLuongBh;
	}

	public float getHsLuongCb() {
		return hsLuongCb;
	}

	public void setHsLuongCb(float hsLuongCb) {
		this.hsLuongCb = hsLuongCb;
	}
	
	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap he so luong bao hiem: ");
		this.hsLuongBh = sc.nextFloat();
		
		System.out.println("Nhap he so luong cap bac: ");
		this.hsLuongCb = sc.nextFloat();
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println(" Hs luong bh: "+ this.hsLuongBh);
		System.out.println(" Hs luong cap bac: "+ this.hsLuongCb);
		System.out.println(" Cong trong thang: "+ this.tinhCong() + "; Luong: "+ this.tinhLuong());
	}

	@Override
	public long tinhLuong() {
		// TODO Auto-generated method stub
		return (long)((this.hsLuongBh + this.hsLuongCb) * this.tinhCong() * 1000);
	}

	@Override
	public float tinhCong() {
		// vi tri nv: nhan vien hoac nv thi 24 ngay cong
		// nguoc lai: 26 ngay cong
		if (this.getViTriLv().startsWith("nv") || this.getViTriLv().contains("nhan vien"))
			return 24;
		else
			return 26;
	}

}
