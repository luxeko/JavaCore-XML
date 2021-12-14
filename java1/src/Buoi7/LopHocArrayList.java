package java1.src.Buoi7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import java1.src.Buoi4.LopHoc;

public class LopHocArrayList {
    public static void main(String[] args) {
        //tao ra 1 mang dong:
        ArrayList danhSach = new ArrayList();
        /** ArList la danh sach chua cac phan tu (khong can cung kieu) 
         *  sap xep co the trung nhau
         * nam theo thu tu -> truy cap thong qua index/chi muc*
         */
        //them 1 phan tu vao ds:
        danhSach.add(1); //0
        danhSach.add("t2103"); //1
        danhSach.add(3.14f); //2
        danhSach.add(true); //3
        danhSach.add(new LopHoc()); //4
        danhSach.add("t2103"); //5
        danhSach.add("test"); //6

        //lay kich thuoc cua ArrayList:
        System.out.println("Kich thuoc cua ds: " + danhSach.size());

        //xoa phan tu cua ArList:
        danhSach.remove(2); //xoa phan tu vi tri so 3
        System.out.println("Kich thuoc cua ds sau remove: " + danhSach.size()); //Kich thuoc sau remove cua ds
        danhSach.remove("t2103"); //xoa cac phan tu cung Object

        //cap nhat gia tri cho phan tu:
        int intdexBoolean = danhSach.indexOf(true); //lay index theo gia tri
        if(intdexBoolean >=0){
            danhSach.set(intdexBoolean, false);
        }

        //check 1 phan tu co nam trong ds hay khong?
        System.out.println(danhSach.contains(1)? "1 ton tai trong ds": "1 khong ton tai");

        //duyet danh sach:
        //while/for/do while
        System.out.println("In cach 1(for):");
        for(int i = 0; i < danhSach.size(); i++){
            System.out.println(danhSach.get(i) + " ");
        }

        System.out.println("In cach 2(foreach): ");
        for(Object obj: danhSach){
            System.out.println(obj + " ");
        }

        //tao ds lop hoc chi chua cac phan tu la kieu LopHoc
        ArrayList<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
        dsLopHoc.add((new LopHoc()));
        LopHoc lophoc1 = new LopHoc("t203", 2021, 16, "c5");
        dsLopHoc.add(lophoc1);
        
		dsLopHoc.add(new LopHoc("t105", 2019, 16, "c5"));
        dsLopHoc.add(new LopHoc("t200", 2020, 16, "c5"));
		dsLopHoc.add(new LopHoc("t205", 2020, 16, "c5"));
        

        System.out.println("In cach 3(iterator): ");
        Iterator<LopHoc> ite = dsLopHoc.iterator();
        while(ite.hasNext()){
            LopHoc obj = ite.next();
            System.out.println(obj.xuat());
        }

        //duyet nguoc listIte.hasPrevious();

        //sap xep 
        Collections.sort(dsLopHoc);
        ListIterator<LopHoc> listIte = dsLopHoc.listIterator();
        while(listIte.hasNext()){
            LopHoc obj = listIte.next();
            System.out.println(obj.xuat());
        }
        
        
        
    }
}
