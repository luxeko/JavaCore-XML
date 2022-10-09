package buoi8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nguoi n1 = new Nguoi();
		Nguoi n2 = new Nguoi("dung", 20, "111", "a");
		
		GiangVien gv1 = new GiangVien();
		GiangVien gv2 = new GiangVien("dung", 20, "222", "b", "gv2", 4, 40);
		
		gv1.setTen("Dungpt20");
		gv1.setTuoi(20);
		
		gv1.setMaGv("gv2");
		gv1.xuat();
		System.out.println("So sanh gia tri gv1 va gv2: "+ gv1.equals(gv2));
		
		Nguoi n3 = new GiangVien();
		// biên dịch: nhap -> Nguoi ( ve trai)
		// thogn dich/ run: nhap -> GiangVien ( ve phai )
		//n3.nhap();
		
		Nguoi n4 = gv2;
		
		//GiangVien gv3 = (GiangVien)new Nguoi();
		GiangVien gv4 = (GiangVien)n4;
		
		
		ArrayList<GiangVien> listGv = new ArrayList<GiangVien>();
		listGv.add(gv1);
		listGv.add(gv2);
		listGv.add((GiangVien) n3);
		
		System.out.println("Size: "+ listGv.size());
		for(int i=0; i< listGv.size(); i++) {
			System.out.println("---Giang vien thu "+ (i+1));
			GiangVien tmp = listGv.get(i);
			tmp.xuat(); // -- giang vien
			tmp.tinhLuong();
		}
		
		// danh sach chua nguoi, giang vien, nhanvien, sinhvien, lanhdao
		ArrayList<Nguoi> listNguoi = new ArrayList<Nguoi>();
		listNguoi.add(n1);
		listNguoi.add(n2);
		listNguoi.add(gv1);
		listNguoi.add(gv2);
		listNguoi.add(n4);
		listNguoi.add(gv4);
		System.out.println("Size List Nguoi: "+ listNguoi.size());
		System.out.println("--------In ra ds nguoi-------");
		for(int i=0; i< listNguoi.size(); i++) {
			System.out.println("-----Nguoi thu "+ (i+1));
			Nguoi tmp = listNguoi.get(i);
			if (tmp instanceof Nguoi) {
				//tmp.xuat();
				System.out.println(tmp);
			}
			// instanceof: so sanh 1 doi tuong co phai la Kieu dinh nghia hay khong?
			if (tmp instanceof GiangVien) {
				((GiangVien)tmp).tinhLuong();
				System.out.println("tmp co phai Nguoi? "+ (tmp instanceof Nguoi));
			}
			
		}
		Integer num = 10;
		if (num instanceof Integer) {
			
		}
		
		System.out.println("End!");
	}

}
