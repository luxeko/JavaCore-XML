package buoi5;

import java.util.Date;

import buoi4.LopHoc;

public class Main {

	public static void main(String[] args) {
		// tao ngay hien tai
		Date ngayht = new Date();
		System.out.println(ngayht);
		
		String ngaymai = "24/08/2021";
		ngaymai = "24821";
		
		//LopHoc lop1 = new LopHoc("t2103e"); // constructor: private: trong cùng class LopHoc
		// constructor: protected: trong cùng class LopHoc hoặc cùng package buoi4 hoặc các lớp dẫn xuất/con
		//LopHoc lop2 = new LopHoc(2021); 
		// constructor: default: trong cùng class LopHoc hoặc cùng package với class LopHoc: buoi4
		//LopHoc lop3 = new LopHoc(); 
		LopHoc lop4 = new LopHoc("t2000", 2020, 20, "C5");  // constructor: public: moi noi
		
		// truy xuất tới các thành phần của lớp:
		//lop4.maLop = "t2103e"; // malop: private
		//lop4.namHoc = 2021; // propeties: protected
		//lop4.soLuongHv = 16; // propeties: default
		lop4.phongHoc = "B11"; // propeties: public
		lop4.setMaLop("t2103e");
		System.out.println("Ma lop : "+ lop4.getMaLop());
	}

}
