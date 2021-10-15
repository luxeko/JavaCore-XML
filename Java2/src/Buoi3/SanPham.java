package Java2.src.Buoi3;

public class SanPham {
    private String maSp;
    private String tenSp;
    private float price;
    public SanPham() {
    }
    public SanPham(String maSp, String tenSp, float price) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.price = price;
    }
    
    public String getMaSp() {
        return maSp;
    }
    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }
    public String getTenSp() {
        return tenSp;
    }
    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "SanPham [maSp=" + maSp + ", price=" + price + ", tenSp=" + tenSp + "]";
    }

    
}
