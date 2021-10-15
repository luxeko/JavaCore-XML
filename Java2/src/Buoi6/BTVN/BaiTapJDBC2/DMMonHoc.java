package Java2.src.Buoi6.BTVN.BaiTapJDBC2;

import java.util.Scanner;

public class DMMonHoc {
    Scanner sc = new Scanner(System.in);
    //-------------FIELD--------------
    private String tenMonHoc;
    private String maMonHoc;
    
    //------------CONTRUCTOR-------------
    public DMMonHoc() {
    }

    public DMMonHoc(String tenMonHoc, String maMonHoc) {
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
    }
    //------------GETTER SETTER--------------
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    //-----------METHOD-----------------
    public void addInfoMonHoc() {
		//FIELD MA MON HOC
		while(true) {
			System.out.print("Nhập mã môn học: ");
			this.maMonHoc = sc.nextLine();
			if(this.maMonHoc.length() != 4) {
				System.out.println("Mã môn học phải có 4 ký tự!");
			}else if(this.maMonHoc.trim().equals("")){
                System.out.println("Bạn chưa nhập mã môn học");
            }
            else {
				break;
			}
		}
		//FIELD TEN MON HOC
		while(true) {
			System.out.print("Nhập tên môn học: ");
			this.tenMonHoc = sc.nextLine();
			if(!this.tenMonHoc.trim().equals("")) {
				break;
			}else {
				System.out.println("Bạn chưa nhập tên môn học");
			}
		}
	}
    
    
}

