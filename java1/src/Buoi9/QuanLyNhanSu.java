package java1.src.Buoi9;

import java.util.ArrayList;
import java.util.Collections;

import java1.src.Buoi8.Nguoi;

public class QuanLyNhanSu {
    private static ArrayList<Nguoi> dsns = new ArrayList<Nguoi>();

    public static ArrayList<Nguoi> getDsns() {
        return dsns;
    }
    public static void setDsns(ArrayList<Nguoi> dsns) {
        QuanLyNhanSu.dsns = dsns;
    }

    //them 1 nguoi vao ds
    // public static void addNew(Nguoi nguoi){
    //     if(nguoi != null){
    //         QuanLyNhanSu.dsns.add(nguoi);
    //     }
    // }
    public static boolean addNew(Nguoi nguoi){
        if(nguoi != null){
            QuanLyNhanSu.dsns.add(nguoi);
            return true;
        }
        return false;
    }
    
    //hien thi ds Nguoi
    public static void showDs(){
        System.out.println("------Danh sach nhan su-----------");
        for (int i = 0; i< QuanLyNhanSu.dsns.size(); i++){
            System.out.println("Nguoi thu: " + (i+1));
            QuanLyNhanSu.dsns.get(i).xuat();
        }
    }

    public static void sapXepNguoiByTenDesc(){
        // sap theo quy tac rieng
		/*
		Collections.sort(QuanLyNhanSu.dsns, new Comparator<Nguoi>() {

			@Override
			public int compare(Nguoi o1, Nguoi o2) {
				// sap xep giam dan thi lay o2 so sanh voi o1
				// sap xep tang dan thi lay o1 so sanh voi o2
				if (o1 == null || o2 == null)
					return 0;
				return o2.getTen().compareTo(o1.getTen());
			}
		});
		*/
        Collections.sort(QuanLyNhanSu.dsns, new SortDSByNameDesc());
        QuanLyNhanSu.showDs();
    }

    //tim phan tu co ton tai trong mang hay ko? co thi tra ve index cua phan tu, khong thi -1
    /**
     * Kieu = 1: tim theo ten nguoi
     * Kieu = 2: tim theo manv
     * Kieu = 3: tim theo magv
     */
    
    public static int find(Nguoi ng, int kieu) {
        if(ng == null)
            return -1;
        if(kieu == 1){
            for(int i = 0; i < QuanLyNhanSu.dsns.size(); i++){
                if(QuanLyNhanSu.dsns.get(i).getTen().equalsIgnoreCase(ng.getTen())) {
                    return i;
                }
            }
            return -1;
        }else if (kieu == 2){
            if(!(ng instanceof NhanVien)){
                return -1;
            }
            for (int i = 0; i < QuanLyNhanSu.dsns.size(); i++){
                if(QuanLyNhanSu.dsns.get(i) instanceof NhanVien){
                    NhanVien tmp = (NhanVien)QuanLyNhanSu.dsns.get(i);
                    if(tmp.getManv().equalsIgnoreCase(((NhanVien)ng).getManv()))
                        return  i;
                }
            }
            return -1;
        }
        return QuanLyNhanSu.dsns.indexOf(ng);
    }
}
