package buoi3;

public class SanPham {
	private String maSp;
	private String tenSp;
	private float price;
	public SanPham(String maSp, String tenSp, float price) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Masp: "+ this.maSp + "; tensp: "+ this.tenSp + "; gia: "+ this.price;
	}
	
	
}
