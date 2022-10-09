package buoi3;

public class SanPhamMua implements Comparable<SanPhamMua>{
	private String maSp;
	private int soLuongMua;
	public SanPhamMua() {
		super();
	}
	public SanPhamMua(String maSp, int soLuongMua) {
		super();
		this.maSp = maSp;
		this.soLuongMua = soLuongMua;
	}
	public String getMaSp() {
		return maSp;
	}
	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (! (o instanceof SanPhamMua)) {
			return false;
		}
		SanPhamMua other = (SanPhamMua) o;
		if (this.maSp != null && this.maSp.equals(other.getMaSp())) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.maSp.hashCode();
	}
	@Override
	public int compareTo(SanPhamMua arg0) {
		if (arg0 == null)
			return 0;
		Integer spMuaWrapper = arg0.getSoLuongMua();
		if (this.soLuongMua == arg0.getSoLuongMua())
			return -1;
		return spMuaWrapper.compareTo(this.soLuongMua);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Masp: "+ this.maSp + "; soluongmua: "+ this.soLuongMua;
	}
	
	
}
