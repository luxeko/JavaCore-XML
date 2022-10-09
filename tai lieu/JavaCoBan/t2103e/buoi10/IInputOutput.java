package buoi10;
/*
 - trừu tượng 100%: không tạo được đối tượng từ Interface
 - biến hằng (final + static)
 - phương thức: abstract: chỉ có khai báo hàm khong có body
 - 1 interface kế thừa được nhiều interface khác
 - 1 class thì chỉ được kế thừa 1 class nhưng được thực thi nhiều interfaces
 * */
public interface IInputOutput {
	String name = "Input Output";
	public static final float PI = 3.14f;
	void nhap();
	public abstract void xuat();
	public static String getName() {
		return name;
	}
}
