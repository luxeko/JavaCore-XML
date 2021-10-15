package java1.src.Buoi7;

import java.util.Scanner;

public class Mang2Chieu {
    public static void main(String[] args) {
        //du lieu can nha trong chung cu
        // String [][] chungt3 = new String[4][3];

        // chungt3[1][1]= "202";
        // chungt3[2][2]= "302";

        // //chung cu t4 co 3 hang, 2 cot:
        // String[][] chungt4 = {{"101", "102"}, {"201", "202"}, {"301", "302"}};
        // System.out.println("Danh sach can ho chung cu t4: ");
        // for(int i=0; i<3; i++){
        //     for(int j=0; j<2; j++){
        //         System.out.print(chungt4[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        //chung cu co 10 tang, moi tang co 5 can ho
        final int SO_TANG = 10;
        final int SO_CAN = 5;
        CanHo[][] chungt2 = new CanHo[SO_TANG][SO_CAN];
        // chungt2[2][4] = new CanHo("204", "Duc Anh");
        Scanner sc = new Scanner(System.in);

        //nhap thong tin can ho trong toa chung cu
        String confirm = "";
        do{
            //Xu ly nghiep vu:
            int tang = 0;
            int can = 0;
            while(true){
                System.out.println("Ban muon nhap can ho tai tang bao nhieu?"); 
                tang = sc.nextInt();
                if(tang >= 0 && tang < SO_TANG){
                    break;
                }
            }
            do{
                System.out.println("Ban muon nhap can ho thu bao nhieu?"); 
                can = sc.nextInt();
            }while(can < 0 || can > SO_CAN);
           
            if(chungt2[tang][can] == null){
                chungt2[tang][can] = new CanHo((tang+1) + "" +(can+1));
                chungt2[tang][can].nhap();

                // chungt2[tang][can] = new CanHo();
				// chungt2[tang][can].nhap((tang+1)+""+ (can+1));
            }else{
                System.out.println("Can ho tang thu " + (tang+1) + " va can thu: " + (can+1) + " da co du lieu");
            }

            System.out.println("Ban co muon dung nhap hay ko?(n: stop)");
            sc.nextLine();
            confirm = sc.nextLine();    
        }while(!confirm.equalsIgnoreCase("n"));

        // xuat du lieu chung cu can ho
        int count=0;
        for(int i=0; i<SO_TANG; i++){
            for(int j=0; j<SO_CAN; j++){
                if(chungt2[i][j] !=null){ 
                    System.out.printf("Can ho tang " + (i+1) + " Can ho thu " + (j+1));
                    // System.out.printf("Can ho tang " + (i+1) + " Can ho thu " + (j+1) + " Ma can ho " + (i+j+1));
                    chungt2[i][j].xuat();
                    count++;
                    
                }else{
                    System.out.println("Can ho tang " + (i+1) + " va can thu: " + (j+1) + " chua co du lieu");
                }       
            }
        }System.out.println("=> So can ho da dang ky: " + count);
        System.out.println("=> So can ho chua dang ky: " + (50-count));
        sc.close();
    }
}
/**
 * Xay dung ham nhat va ham xuat cua Can Ho
 * Nhap can ho moi chung cu ( mcan dc sinh ra tự động từ số tầng + số căn)
 * Xuat thong tin ds can ho trong chung cu
 * Xac dinh chung cu do co bao nhieu can ho da co du lieu va bao nhieu can chua co du lieu
 */

class CanHo{
    Scanner sc = new Scanner(System.in);
    private String maCan;
    private String chuHo;
    
    public CanHo(String maCan, String chuHo) {
        this.maCan = maCan;
        this.chuHo = chuHo;
    }
    public CanHo(String maCan){
        this.maCan = maCan;
    }
    public String getMaCan() {
        return maCan;
    }
    public void setMaCan(String maCan) {
        this.maCan = maCan;
    }
    public String getChuHo() {
        return chuHo;
    }
    public void setChuHo(String chuHo) {
        this.chuHo = chuHo;
    }
    public void nhap(){
        System.out.println("Nhap ten chu can ho: ");
        this.chuHo = sc.nextLine();
    }
    // public void nhap(String macn) {
	// 	Scanner sc = new Scanner(System.in);
	// 	if (macn != null) {
	// 		this.maCan = macn;
	// 	}
	// 	System.out.println("Chu ho: ");
	// 	this.chuHo = sc.nextLine();
	// }
    public void xuat(){
        System.out.printf(" Ma can ho: %s" , this.maCan);
        System.out.printf(" Chu can ho: %s%n" , this.chuHo);
    }

}
