package Java2.src.Assignment.Manager.imp;
import java.util.List;
import Java2.src.Assignment.Obj.KhachHang;

public interface IKhachHangDao {
    public void createKhachHang(KhachHang kh);
    public void updateKhachHang(KhachHang kh);
    public void deleteKhachHang();
    public List<KhachHang> displayListKhachHang();
}
