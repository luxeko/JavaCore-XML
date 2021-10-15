package Java2.src.Assignment.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaoDich {
    private int id;
    private String soTK;
    private String loaiThaoTac;
    private Double soTien;
    private Date ngayGiaoDich;
    private String noiThucHien;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public GiaoDich() {
    }
    public GiaoDich(int id, String soTK, String loaiThaoTac, Double soTien, Date ngayGiaoDich, String noiThucHien) {
        this.id = id;
        this.soTK = soTK;
        this.loaiThaoTac = loaiThaoTac;
        this.soTien = soTien;
        this.ngayGiaoDich = ngayGiaoDich;
        this.noiThucHien = noiThucHien;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSoTK() {
        return soTK;
    }
    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }
    public String getLoaiThaoTac() {
        return loaiThaoTac;
    }
    public void setLoaiThaoTac(String loaiThaoTac) {
        this.loaiThaoTac = loaiThaoTac;
    }
    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }
    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
    public Double getSoTien() {
        return soTien;
    }
    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }
    public String getNoiThucHien() {
        return noiThucHien;
    }
    public void setNoiThucHien(String noiThucHien) {
        this.noiThucHien = noiThucHien;
    }
    @Override
    public String toString() {
        return "GiaoDich ID: " + id + "   " + "loaiThaoTac: " + loaiThaoTac + "   " + "ngayGiaoDich: " + sdf.format(ngayGiaoDich) + "   "
                + "noiThucHien: " + noiThucHien + "   " + "soTK: " + soTK + "   " + "soTien: " + soTien + "\n";
    }
    public void output(){
        System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n",  
                            this.id,
                            this.soTK,
                            this.loaiThaoTac,
                            this.soTien,
                            sdf.format(this.ngayGiaoDich),
                            this.noiThucHien);
    }
    
    
}
