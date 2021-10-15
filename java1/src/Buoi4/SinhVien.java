package java1.src.Buoi4;

import java.util.Scanner;

public class SinhVien {

    String tenSV, maSV, email;
    int namSinh;
    float diemToan, diemVan, diemAnh;

    public SinhVien(String tenSV, String maSV, String email, int namSinh, float diemToan, float diemVan, float diemAnh){
        this.tenSV = tenSV;
        this.maSV = maSV;
        this.email = email;
        this.namSinh = namSinh;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
    }
    public SinhVien(){

    }
   

    void nhap(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("---Quản Lý Sinh VIên---");
            System.out.println("-------------------------------");
            System.out.printf("Nhập họ và tên: ");
            this.tenSV = input.nextLine();
            System.out.printf("Nhập mã sinh viên: ");
            this.maSV = input.nextLine();
            while(true){
                System.out.printf("Nhập năm sinh: ");
                this.namSinh = input.nextInt();
                input.nextLine();
                if (this.namSinh > 0){
                    System.out.printf("Nhập email: ");
                    this.email = input.nextLine();
                    while(true){
                        System.out.printf("Nhập điểm toán: ");
                        this.diemToan = input.nextFloat();
                        System.out.printf("Nhập điểm văn: ");
                        this.diemVan = input.nextFloat();
                        System.out.printf("Nhập điểm anh: ");
                        this.diemAnh = input.nextFloat();
                        if((0 < this.diemAnh && this.diemAnh < 11) && (0 < this.diemToan && this.diemToan < 11) && (0 < this.diemVan && this.diemVan < 11)){
                            break;
                        }
                        else{
                            System.out.println("Vui lòng nhập điểm trong khoảng 0 - 10");	
                        }
                    }break;
                }else{
                    System.out.println("Vui lòng nhập năm sinh lớn hơn 0");	
                }
            }
        break;
        }
        input.close();
    }

    String xuat(){
        return "-------------------------------" + "\n" +
                "Ho va Ten: " + this.tenSV + "\n" +
                "Ma sinh vien: " + this.maSV + "\n" +
                "Nam sinh: " + this.namSinh + "\n" +
                "Email: " + this.email + "\n" +
                "Diem Toan: " + this.diemToan + "\n" +
                "Diem Van: " + this.diemVan + "\n" +
                "Diem Anh: " + this.diemAnh;
    }
    String hocluc(){
        float diemTB = (this.diemToan + this.diemVan + this.diemAnh)/3;
        String xeploai = null;
        if(diemTB < 5 && diemTB > 0) {
			xeploai = "Yếu";
		}else if(diemTB < 7) {
			xeploai = "Trung Bình";
		}else if(diemTB <= 9) {
			xeploai = "Khá";
		}else if (diemTB < 11) {
			xeploai = "Giỏi";
		}
		return "Điểm TB của " + this.tenSV + ": "  + diemTB + "\n" +
				"Học lực: " + xeploai;

    }
    public static void main(String[] args) {
		SinhVien bai2 = new SinhVien();
		bai2.nhap();
		System.out.println(bai2.xuat());
		System.out.println(bai2.hocluc());
	}

}
