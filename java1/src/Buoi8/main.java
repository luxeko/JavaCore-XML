package java1.src.Buoi8;

import java.util.ArrayList;

public class main {
    public static void Main(String[] args) {
        Nguoi n1 = new Nguoi();//cach 1
        Nguoi n2 = new Nguoi("DucAnh", 22, "000", "a"); //cach 2

        GiangVien gv1 = new GiangVien(); //cach 1
        GiangVien gv2 = new GiangVien("DucAnh", 22, "222", "b", "gv2", 4, 40); //cach 2

        gv1.setTen("DucAnhLe");
        gv1.setTuoi(22);
        
        gv1.setMaGv("gv2");
        gv1.xuat();
        System.out.println("So sanh gia tri gv1 va gv2: " + gv1.equals(gv2));

        Nguoi n3 = new GiangVien(); //ong GV thua huong tu ong Nguoi
        n3.nhap();

        //bien dich: nhap -> Nguoi(ve trai)
        //thong dich/run: nhap -> GiangVien(ve phai)
        // ((GiangVien)n3).nhapGV();
        Nguoi n4 = gv2; 

        // GiangVien gv3 = new Nguoi(); //sai vi Nguoi ko ke thua cac tinh chat cua GV
        // GiangVien gv3 = (GiangVien) new Nguoi(); // ep kieu //ko dc vi Nguoi chac chan la Cha va ko the ep kieu

        // GiangVien gv4 = n4; // cung loi vi ong n4 la mot Nguoi mac du = gv2
        GiangVien gv4 = (GiangVien)n4; // ep kieu // dc vi n4 da gan gia tri la GiangVien (gv2)

        // => Con chac chan duoc thua huong tu Cha, nhung Cha chua chac da dc thua huong tu Con

        ArrayList<GiangVien> listGv = new ArrayList<GiangVien>();
        listGv.add(gv1);
        listGv.add(gv2);
        listGv.add((GiangVien) n3);
        listGv.add((GiangVien) n4);
        System.out.println("Size GV " + listGv.size());
        for(int i = 0; i<listGv.size(); i++){
            System.out.println("---Giang vien thu " + (i+1) + "---");
            GiangVien tmp = listGv.get(i);           
            if(tmp instanceof Nguoi){
                tmp.xuat(); // xuat cua giang vien
                tmp.tinhLuong();
            }
        }

        //danh sach chua nguoi, giang vien, nhan vien, sinh vien, lanh dao
        ArrayList<Nguoi> listNguoi = new ArrayList<Nguoi>();
        listNguoi.add(n1);
        listNguoi.add(n2);
        listNguoi.add(gv1);
        listNguoi.add(gv2);
        listNguoi.add(n3);
        listNguoi.add(n4);
        listNguoi.add(gv4);
        System.out.println("Size Nguoi" + listNguoi.size());
        System.out.println("---In ra ds nguoi---");
        for(int i = 0; i < listNguoi.size(); i++){
            System.out.println("---Nguoi thu " + (i+1) + "---");
            Nguoi tmp = listNguoi.get(i);
            tmp.xuat(); //xuat cua nguoi
            //System.out.println(tmp); // Ham cua toString. dung toString() thi ko dung xuat()

            //instanceof: so sanh 1 doi tuong co phai la kieu dinh nghia hay ko?(ko phai la kieu nguyen thuy)
            if(tmp instanceof GiangVien){
                ((GiangVien)tmp).tinhLuong();
                System.out.println("tmp co phai Nguoi? " + (tmp instanceof Nguoi));
            }
        }
        Integer num = 10;
        if(num instanceof Integer){

        }
        System.out.println("End!");


    }
}
