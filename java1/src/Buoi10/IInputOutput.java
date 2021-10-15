package java1.src.Buoi10;
/*
    - Truu tuong 100%: khong tao dc doi tuong tu interface
    - bien hang (final + static)
    - phuong thuc: abstract: chi co khai bao ham ko co body
    - 1 interface ke thua dc nhieu interface khac
    - 1 class thi chi ke thua 1 class nhưng dc thuc thi nhieu interface 
 */
public interface IInputOutput { 
    String name = "Input Output";
	public static final float PI = 3.14f;
	void nhap();
	public abstract void xuat();
	public static String getName() {
		return name;
	}
}
