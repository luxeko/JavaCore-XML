package Java2.src.Assignment.Manager.imp;
import java.util.List;
import Java2.src.Assignment.Obj.TaiKhoan;

public interface ITaiKhoanDao {
    public void createAccount(TaiKhoan tk);
	public void payinAccount();
	public void withdrawAccount();
	public List<TaiKhoan> displayAccountInfoByAccountId(); //show account by account ID
	public List<TaiKhoan> displayAccountByCustomerId(); // show visa and default account
    public List<TaiKhoan> displayListTaiKhoan();
}
