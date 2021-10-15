package java1.src.Buoi6;

import java.util.Scanner;

import java1.src.Buoi4.LopHoc;

    /**
     * Viet chuong trinh nhap LopHoc vao mang
     * In ra thong tin LopHoc trong mang
     * Tim LopHoc co ton tai hay khong? Co thi in ra
     * Sap xep ca LopHoc co trong mang theo chieu giam dan cua MaLop
     */

public class MangLopHoc {
    private LopHoc [] dsLopHoc = new LopHoc[50];
    //Bien danh dau so luong phan tu lophoc !=null trong dsLopHoc
    private int count = 0;

    public MangLopHoc(){
        this.dsLopHoc = new LopHoc[50];
        this.count = 0;
    }
    public LopHoc[] getDsLopHoc() {
        return dsLopHoc;
    }
    public void setDsLopHoc(LopHoc[] dsLopHoc) {
        this.dsLopHoc = dsLopHoc;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    //them 1 lophoc tu ban phim vao mang
    public void addLopHoc(){
        //tao 1 lop hoc va nhap thong tin
        LopHoc tenLop = new LopHoc();
        tenLop.nhap();
        // add vao mang
        this.dsLopHoc[this.count++] = tenLop;
    }
    // in ra ds cac phan tu !=null cua mang
    public void showDs(){
        System.out.println("In danh sach lop hoc: ");
        for(int i = 0; i < this.count; i++){
            System.out.println("Lop hoc thu: " + (i+1));
            System.out.println(this.dsLopHoc[i].xuat());
        }
    }
    public LopHoc searchDs(){
        //nhap 1 ma lop roi tra ve lop hoc co malop = malop nhap
        Scanner sc = new Scanner(System.in);
        System.out.println("=================");
        //tim lop hoc
        System.out.printf("Tim lop hoc: "); 
        String malopfind = sc.nextLine(); 
        sc.close();
        for(int i = 0;i < this.count; i++){
            LopHoc timlop = this.dsLopHoc[i];
            if(malopfind.equalsIgnoreCase(timlop.getMaLop())){
               return timlop;
            }
        }
        return null;
    }
    //sap xem giam dan lop hoc theo ma
    public void sortDs(){
        LopHoc temp;
        for(int i = 0; i < this.count-1; i++){
            for(int j = i+1; j < this.count; j++){
                 //So sanh giam dan
                if(this.dsLopHoc[i].getMaLop().compareTo(this.dsLopHoc[j].getMaLop())<0){

                //So sanh tang dan
                //if(this.dsLopHoc[i].getMaLop().compareTo(this.dsLopHoc[j].getMaLop())>0){
                    temp = this.dsLopHoc[i];
                    this.dsLopHoc[i] = this.dsLopHoc[j];
                    this.dsLopHoc[j] = temp;
                }
            }           
        }
    }
    public void sumLopHoc(){
        int sum = 0;
        int quantity;
        //So luong lop hoc
        for(quantity = 1; quantity < this.count; quantity++){
            quantity++;
        }
        System.out.println();
        //So luong hoc sinh cua cac lop
        for(int i = 0; i < this.count; i++){
            sum += this.dsLopHoc[i].getSoLuongHv();
        }
        System.out.println("Tong so lop hoc: " + quantity);
        System.out.println("Tong so luong hoc sinh cua cac lop: " + sum);
    }
    public void minMax(){
            int min = this.dsLopHoc[0].getSoLuongHv();
            int max = this.dsLopHoc[0].getSoLuongHv();
            String posMin = this.dsLopHoc[0].getMaLop();
            String posMax = this.dsLopHoc[0].getMaLop();
            for(int i=0; i < this.count; i++){
                if(min > this.dsLopHoc[i].getSoLuongHv()){
                    min = this.dsLopHoc[i].getSoLuongHv();
                    posMin = this.dsLopHoc[i].getMaLop();
                }
                if(max < this.dsLopHoc[i].getSoLuongHv()){
                    max = this.dsLopHoc[i].getSoLuongHv();
                    posMax = this.dsLopHoc[i].getMaLop();
                }
            }   
            System.out.println("Lop " + posMin + " co so luong hoc vien nho nhat: " + min);
            System.out.println("Lop " + posMax + " co so luong hoc vien lon nhat: " + max);
        }
    public void sortHocVien(){
        LopHoc temp2;
        for(int i = 0; i < this.count; i++){
            for(int j = i + 1; j < this.count; j++){
                //Sao xep so luong hoc vien tang dan
                if(this.dsLopHoc[i].getSoLuongHv() > this.dsLopHoc[j].getSoLuongHv()){
                    temp2 = this.dsLopHoc[i];
                    this.dsLopHoc[i] = this.dsLopHoc[j];
                    this.dsLopHoc[j] = temp2;
                }
            }
        }
    }
}
