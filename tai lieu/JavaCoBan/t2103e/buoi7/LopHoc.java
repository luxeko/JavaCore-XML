package buoi7;

import java.util.Scanner;

//tạo ra 1 template/ mẫu định nghĩa cho các lơp học
//khai báo: Danh từ viết hoa
public class LopHoc implements Comparable<LopHoc>{
	// fields -> các biến instance
	/*
	 * malop, namhoc, soluonghv, phonghoc
	 * */
	// khai báo biến: danh từ thường
	// <phạm vi truy xuất> <kiểu biến> <tên biến>;
	
	// thuộc tính: private
	private String maLop;
	protected int namHoc;
	int soLuongHv;
	public String phongHoc;
	
	// hàm get/set
	// gán giá trị cho thuộc tính
	public void setMaLop(String malop){
		this.maLop = "FPT_"+malop;
	}
	// hàm get: trả về giá trị của thuộc tính
	public String getMaLop(){
		return this.maLop.toUpperCase();
	}
	
	// khai báo hàm:
	// <phạm vi truy xuất> <kiểu trả về> <tên hàm> (<ds tham số>) {
	//}
	// methods: hàm -> động từ bắt đầu viết thường
	// hàm khởi tạo: constructor: hàm không có kiểu trả về và tên hàm trùng với tên lớp
	// constructor: để tạo được 1 đối tượng/ instance/ thể hiện mới => new
	// và gán các giá trị mặc định cho các biến instance của instance
	// constructor: public
	private LopHoc(String maLop){
		// this: đại diện cho đối tượng hiện tại
		this.maLop = maLop;
	}
	LopHoc(int nh){
		this.namHoc = nh;
	}
	public LopHoc(){
	}
	public LopHoc(String ml, int nh, int soLuongHv, String phongHoc){
		this.maLop = ml;
		this.namHoc = nh;
		this.soLuongHv = soLuongHv;
		this.phongHoc = phongHoc;
		
	}
	
	public Integer getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}
	// this: trả về đối tượng hiện tại:
	LopHoc copy(){
		return this;
	}
	// hàm nghiệp vụ: public
	// ham diHoc: hàm instance/ đối tượng/ thể hiện
	void diHoc(int kyHoc){
		if (kyHoc % 2 == 0){
			System.out.println("Lich hoc "+kyHoc+" 2,4,6 trong tuan");
		} else {
			System.out.println("Lich hoc "+kyHoc+" 3,5,7 trong tuan");
		}
	}
	public void nhap(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma lop: ");
		this.maLop = sc.nextLine();
		System.out.println("Nhap nam hoc: ");
		this.namHoc = sc.nextInt();
		System.out.println("So luong hoc vien: ");
		this.soLuongHv = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap phong hoc: ");
		this.phongHoc = sc.nextLine();
	}
	public String xuat(){
		return "Ma lop: "+ this.maLop
				+ "; nam hoc: "+ this.namHoc 
				+ "; sl hoc vien: "+ this.soLuongHv
				+ "; phong hoc: "+ this.phongHoc;
	}
	static void test(){
		//this.maLop = "acb";
		// this khong duoc dung trong cac ham statis
	}
	// hàm đặc biệt -> hàm lớp (static)
	public static void main(String[] args) {
		LopHoc t2103e = new LopHoc("T2103E");
		t2103e.nhap();
		System.out.println("ma lop: "+ t2103e.maLop + "; nam hoc: "+ t2103e.namHoc);
		System.out.println(t2103e.xuat());
	}
	public static void main2(String[] args) {
		// tạo đối tượng
		// khai báo biến đối tương
		// biến local
		LopHoc t2103e; // giá trị  = null
		
		// gán giá trị cho biến đối tượng.
		t2103e = null;
		System.out.println(t2103e);
		t2103e = new LopHoc("T2103E");
		System.out.println(t2103e.xuat());
		System.out.println(t2103e);
		//t2103e.maLop = "T2103E";
		t2103e.namHoc = 2020;
		t2103e.soLuongHv = 16;
		t2103e.phongHoc = "C5";
		
		System.out.println(t2103e.xuat());
		t2103e.diHoc(2);
		
		System.out.println(t2103e);
		// toán tử new: tạo ra 1 đối tượng mới
		LopHoc t2000e = new LopHoc("T2000E", 2019, 20, "B11");
		// để các biến đối tượng được tham chiếu (.) thì biến đối tượng đó phải != null
		// gán thuộc tính maLop của đối tượng t2000e = "T2000E"
		/*
		t2000e.maLop = "T2000E";
		t2000e.namHoc = 2019;
		t2000e.soLuongHv = 20;
		t2000e.phongHoc = "B11";
		*/
		System.out.println(t2000e);
		t2000e.diHoc(1);
		// biến local
		int namHoc = 2020;
		System.out.println(t2000e);
		LopHoc t3000e = t2000e.copy();
		System.out.println(t3000e);
		
		System.out.println(t3000e.xuat());
		
	}
	// dinh nghia quy tac sap xep:
	// sap xep ds lop hoc tang dan theo nam va cung nam thi tang dan theo ma lop
	@Override
	public int compareTo(LopHoc o) {
		// TODO Auto-generated method stub
		// e1.compareTo(e2):
		// = 0: e1 = e2
		// tang dan: e1.compareTo(e2)
		// giam dan: e2.compareTo(e1)
		//int 
		int sosanhNam = this.getNamHoc().compareTo(o.getNamHoc());
		if (sosanhNam == 0) {
			//cung nam thi tang dan theo ma lop
			return this.getMaLop().compareTo(o.getMaLop());
		}
		return sosanhNam;
	}
}