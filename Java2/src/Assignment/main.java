package Java2.src.Assignment;

import java.util.Scanner;

import Java2.src.Assignment.Manager.QuanLyGiaoDich;
import Java2.src.Assignment.Manager.QuanLyKhachHang;
import Java2.src.Assignment.Manager.QuanLyTaiKhoan;
import Java2.src.Assignment.Obj.KhachHang;
import Java2.src.Assignment.Obj.TaiKhoan;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        KhachHang kh = new KhachHang();
        TaiKhoan tk = new TaiKhoan();
		QuanLyKhachHang qlkh = new QuanLyKhachHang();
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        int functionID;
        boolean flag = true;
        do {
            showMenu();
            try {
                System.out.printf("Chọn: ");
                functionID = Integer.parseInt(sc.nextLine());
                switch (functionID) {
                    case 1:
                        boolean checkKH = true;
                        int chooseKH;
                        do{
                            System.out.println("1.1 Thêm khách hàng");
                            System.out.println("1.2 Hiển thị danh sách khách hàng");
                            System.out.println("1.3 Cập nhât thông tin khách hàng theo mã khách hàng");
                            System.out.println("1.4 Xoá 1 khách hàng(Lỗi nếu khách hàng đã tạo tài khoản!)");
                            System.out.println("1.5 Thoát");
                            System.out.println("Choose: ");
                            try {
                                chooseKH = Integer.parseInt(sc.nextLine());
                                switch (chooseKH) {
                                    case 1:
                                        qlkh.createKhachHang(kh);
                                        break;
                                    case 2:
                                        qlkh.displayList();
                                        break;
                                    case 3:
                                        qlkh.updateKhachHang(kh);
                                        break;
                                    case 4: 
                                        qlkh.deleteKhachHang();
                                        break;
                                    case 5:
                                        System.out.println("Kết thúc!");
                                        break;
                                    default:
                                        System.out.println("Nhập sai!. Vui lòng nhập lại");
                                }
                                if(chooseKH == 5) checkKH = false;
                            } catch (Exception e) {
                                System.out.println("ERROR FOUND  " + e.getMessage());
                                e.printStackTrace();
                            }
                        }while(checkKH == true);
                        break;
                    case 2:
                        boolean checkTK = true;
                        int chooseTK;
                        do{
                            System.out.println("2.1 Thêm tài khoản");
                            System.out.println("2.2 Nạp tiền vào tk trả trước");
                            System.out.println("2.3 Rút/ Thanh toán tiền");
                            System.out.println("2.4 Hiển thị thông tin tài khoản từ số tài khoản");
                            System.out.println("2.5 Hiển thị thông tin các tài khoản từ mã khách hàng");
                            System.out.println("2.6 Thoát");
                            System.out.println("Choose: ");
                            try {
                                chooseTK = Integer.parseInt(sc.nextLine());
                                switch (chooseTK) {
                                    case 1:
                                        qltk.createAccount(tk);
                                        break;
                                    case 2:
                                        qltk.payinAccount();
                                        break;
                                    case 3: 
                                        qltk.withdrawAccount();
                                        break;
                                    case 4:
                                        qltk.displayAccountInfoByAccountId();
                                        break;
                                    case 5:
                                        qltk.displayAccountByCustomerId();
                                        break;
                                    case 6:
                                        System.out.println("Kết thúc!");
                                        break;
                                    default:
                                        System.out.println("Nhập sai!. Vui lòng nhập lại");
                                }
                                if(chooseTK == 6) checkTK = false;
                            } catch (Exception e) {
                                System.out.println("ERROR FOUND  " + e.getMessage());
                                e.printStackTrace();
                            }
                        }while(checkTK == true);
                        break;
                    case 3:
                        boolean checkGD = true;
                        int chooseGD;
                        do{
                            System.out.println("3.1 Hiển thị thông tin các giao dịch của 1 tài khoản trong khoảng thời gian");
                            System.out.println("3.2 Hiển thị thông tin các giao dịch của 1 khách hàng trong khoảng thời gian");
                            System.out.println("3.3 Xuất file chứa các giao dịch theo tháng nhập từ bàn phím (MM/yyyy) của mỗi khách hàng");
                            System.out.println("3.4 Thoát");
                            System.out.println("Choose: ");
                            try {
                                chooseGD = Integer.parseInt(sc.nextLine());
                                switch (chooseGD) {
                                    case 1:
                                        qlgd.displayTransactionLogBysoTK();
                                        break;
                                    case 2:
                                        qlgd.displayTransactionLogByCustomerID();
                                        break;
                                    case 3: 

                                        break;
                                    case 4:
                                        System.out.println("Kết thúc!");
                                        break;
                                    default:
                                        System.out.println("Nhập sai!. Vui lòng nhập lại");
                                }
                                if(chooseGD == 4) checkGD = false;
                            } catch (Exception e) {
                                System.out.println("ERROR FOUND  " + e.getMessage());
                                e.printStackTrace();
                            }
                        }while(checkGD == true);
                        break;
                    case 4:
                        System.out.println("Thoát!");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn! Vui lòng nhập lại");
                }
                if(functionID == 4) flag = false;
            } catch (Exception e) {
                System.out.println("Error Found "+ e.getMessage());
            }
           
        } while (flag == true);
    }
    public static void showMenu() {
        System.out.println("====== Quản lý thông tin Ngân Hàng ======");
        System.out.println("1. CRUB Khách Hàng");
        System.out.println("2. CRUB Tài khoản");
        System.out.println("3. Report");  
        System.out.println("4. Thoát");
    }
}
