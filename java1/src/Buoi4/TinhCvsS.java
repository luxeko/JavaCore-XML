package java1.src.Buoi4;

import java.util.Scanner;

public class TinhCvsS {
    float a, b, c;
    float dai, rong;
    float canhVuong;
    float banKinh;

    Scanner sc = new Scanner(System.in);
    String tamGiac(){
        float cTamgiac = this.a + this.b + this.c;
        float nuachuvi = cTamgiac/2;
        float sTamgiac =  (float)(Math.sqrt((nuachuvi)* (nuachuvi - this.a) * (nuachuvi - this.b) * (nuachuvi - this.c)) );
		return "Chu vi tam giac la: " + cTamgiac + "\n" +
				"Dien tich tam giac la: " + sTamgiac + "\n";
    }
    String chuNhat(){
        float cchuNhat = (this.dai + this.rong)*2;
        float schuNhat = this.dai * this.rong;
        return "Chu vi HCN la: " + cchuNhat + "\n" +
                "Dien tich HCN la: " + schuNhat + "\n";
    }

    String vuong(){ 
        float cVuong = this.canhVuong * 4;
        float sVuong = this.canhVuong * this.canhVuong;
       return "Chu vi HV la: " + cVuong +"\n" +
                "Dien tich HV la: " + sVuong + "\n";
    }

    String hinhTron(){
        float cTron = (float)(this.banKinh*2*Math.PI);
        float sTron = (float)(this.banKinh*this.banKinh*Math.PI);
        return "Chu vi hinh tron la: " + cTron + "\n" +
                "Dien tich hinh tron la: " + sTron + "\n";
    }

    public void nhap(){
        System.out.println("Chuong trinh tinh Chu Vi va Dien Tich");
        while(true){
            System.out.println("-------------------------------------");
            System.out.println("1: Hinh Tam Giac");
            System.out.println("2: Hinh Chu Nhat");
            System.out.println("3: Hinh Vuong");
            System.out.println("4: Hinh Tron");
            System.out.printf("Vui long chon hinh can tinh: ");

            int choose = sc.nextInt();
            if(choose >= 1 && choose <=4){
                switch(choose){
                    case 1: 
                        while(true){
                            System.out.println("Nhap canh a: ");
                                this.a = sc.nextFloat();
                            System.out.println("Nhap canh b: ");
                                this.b = sc.nextFloat();
                            System.out.println("Nhap canh c: ");
                                this.c = sc.nextFloat();
                            if(this.a > 0 && this.b > 0 && this.c > 0){
                                System.out.println(tamGiac());
                                break;
                            }else{
                                System.out.println("Do dai canh khong hop le!");
                            }
                        }break;
                    case 2: 
                        while(true){
                            System.out.println("Nhap chieu dai: ");
                            this.dai = sc.nextFloat();
                            System.out.println("Nhap chieu rong: ");
                                this.rong = sc.nextFloat();
                            if( this.rong > 0 && this.dai > 0){
                                if(this.dai > this.rong ){
                                    System.out.println(chuNhat());
                                    break;
                                }else{
                                    System.out.println("Chieu dai phai lon hon chieu rong!");
                                }
                            }
                            else{
                                System.out.println("Do dai canh khong hop le!");
                            }
                        }break;
                    case 3:
                        while(true){
                            System.out.println("Nhap canh hinh vuong: ");
                            this.canhVuong = sc.nextFloat();
                            if(this.canhVuong > 0){
                                System.out.println(vuong());
                                break;
                            }else{
                                System.out.println("Do dai canh khong hop le!");
                            }
                        }break;
                    case 4:
                        while(true){
                            System.out.println("Nhap ban kinh hinh tron: ");
                                this.banKinh = sc.nextFloat();
                            if(this.banKinh > 0){
                                System.out.println(hinhTron());
                                break;
                            }else{
                                System.out.println("Do dai canh khong hop le!");
                            }
                        }break;
                }break;
            }else{
                System.out.println("Vui long chon hinh can tinh toan");
            }  
        }
    }
    void goBack(){
        while(true){
            System.out.println("Ban co muon thuc hien lai phep tinh?");
            System.out.println("(1: Có)");
            System.out.println("(2: Không)");
			int conti = sc.nextInt();
            if(conti == 1) {
                this.nhap();
            }	
            else{
                System.out.println("Thank You");
                break;
            }
        }
    }
    public static void main(String[] args){
        TinhCvsS caculator = new TinhCvsS();
        caculator.nhap();
        caculator.goBack();
    }
}
