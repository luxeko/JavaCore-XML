package buoi7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;


public class LopHocArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// tao ra 1 mang dong:
		ArrayList danhsach = new ArrayList();
		/*ArrayList la danh sach chua cac phan tu (khong can cung kieu) 
		 * va co the trung nhau
		 * va nam theo thu tu -> truy cap thong qua index/chi muc*/
		// them 1 phan tu vao ds:
		danhsach.add(1);
		danhsach.add("t201");
		danhsach.add(3.14f);
		danhsach.add(true);
		danhsach.add(new LopHoc());
		danhsach.add("t201");
		danhsach.add("test");
		// lay kich thuoc cua danh sach:
		System.out.println("Kich thuoc cua ds: "+ danhsach.size());
		// xoa phan tu ra khoi danh sach:
		danhsach.remove("t201");
		System.out.println("Kich thuoc sau remove cua ds: "+ danhsach.size());
		// lay index theo gia tri
		int indexBoolean = danhsach.indexOf(true);
		// cap nhat gia tri cho phan tu:
		if (indexBoolean >= 0) {
			danhsach.set(indexBoolean, false);
		}
		// check 1 phan tu co nam trong ds hay khog?
		System.out.println(danhsach.contains(1)?" 1 ton tai trong ds": "1 khong ton tai.");
		// duyet ds:
		//while/ for/ do while
		System.out.println("In ds 1 for: ");
		for(int i=0; i < danhsach.size(); i++) {
			System.out.print(danhsach.get(i) + "   ");
		}
		System.out.println("\nIn ds 2 foreach: ");
		for(Object obj : danhsach) {
			System.out.print(obj + "   ");
		}
		
		// tao ds lop hoc chi chua cac phan tu la kieu LopHoc
		ArrayList<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
		dsLopHoc.add(new LopHoc());
		LopHoc lh1 = new LopHoc("t201", 2020, 16, "c5");
		dsLopHoc.add(lh1);
		dsLopHoc.add(new LopHoc("t200", 2020, 16, "c5"));
		dsLopHoc.add(new LopHoc("t205", 2020, 16, "c5"));
		dsLopHoc.add(new LopHoc("t105", 2019, 16, "c5"));
		
		
		System.out.println("\nIn ds 3 iterator truoc sap xep: ");
		Iterator<LopHoc> ite = dsLopHoc.iterator();
		while (ite.hasNext()) {
			LopHoc obj = ite.next();
			System.out.println(obj.xuat());
		}
		
		// duyet nguoc 
		// sap xep:
		Collections.sort(dsLopHoc);
		
		System.out.println("\nIn ds 4 list iterator sau sap xep: ");
		ListIterator<LopHoc> listite = dsLopHoc.listIterator();
		while(listite.hasNext()) {
			LopHoc obj = listite.next();
			System.out.println(obj.xuat());
		}
	}

}
