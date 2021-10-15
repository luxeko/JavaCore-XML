package java1.src.Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        DsNhomHang dsnh = new DsNhomHang();
        DsSanPham dssp = new DsSanPham();
        DsDonHang dsdh = new DsDonHang();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    boolean check = true;
                    int choose;
                    do{
                        System.out.println("1.1 Thêm nhóm hàng mới");
                        System.out.println("1.2 Hiển thị danh sách nhóm hàng");
                        System.out.println("1.3 Tìm kiếm nhóm hàng theo mã");
                        System.out.println("1.4 Thoát");
                        System.out.println("Choose: ");
                        choose = Integer.parseInt(sc.nextLine());
                        switch (choose) {
                            case 1:
                                NhomHang nh = new NhomHang();
                                nh.input();
                                dsnh.addNhomHang(nh);
                                break;
                            case 2:
                                dsnh.output();
                                break;
                            case 3: 
                                dsnh.timNhomHang();
                                break;
                            case 4:
                                System.out.println("Kết thúc Crud Nhóm Hàng!");
                                break;
                            default:
                                System.out.println("Nhập sai!. Vui lòng nhập lại");
                        }
                        if(choose == 4) check = false;
                    }while(check == true);
                    break;
                case 2:
                    boolean checkSP = true;
                    int chooseSP;
                    do{
                        System.out.println("2.1 Thêm sản phẩm mới");
                        System.out.println("2.2 Hiển thị danh sách sản phẩm");
                        System.out.println("2.3 Tìm kiếm sản phẩm theo mã");
                        System.out.println("2.4 Cập nhật sản phẩm");
                        System.out.println("2.5 Thoát");
                        System.out.println("Choose: ");
                        chooseSP = Integer.parseInt(sc.nextLine());
                        switch (chooseSP) {
                            case 1:
                                dsnh.inMaNhomHang();
                                SanPham sp = new SanPham();
                                sp.input(dsnh);
                                dssp.addSanPham(sp);
                                break;
                            case 2:
                                dssp.output();
                                break;
                            case 3: 
                                dssp.timSanPham();
                                break;
                            case 4: 
                                dssp.inMaSanPham();
                                dssp.capNhatSanPham(dsnh);
                                break;
                            case 5:
                                System.out.println("Kết thúc Crud Sản Phảm!");
                                break;
                            default:
                                System.out.println("Nhập sai!. Vui lòng nhập lại");
                        }
                        if(chooseSP == 5) checkSP = false;
                    }while(checkSP == true);
                    break;
                case 3:
                    boolean checkDH = true;
                    int chooseDH;
                    do{
                        System.out.println("3.1 Thêm đơn hàng mới");
                        System.out.println("3.2 Hiển thị danh sách đơn hàng");
                        System.out.println("3.3 Thoát");
                        System.out.println("Choose: ");
                        chooseDH = Integer.parseInt(sc.nextLine());
                        switch (chooseDH) {
                            case 1:
                                dssp.inMaSanPham();
                                DonHang dh = new DonHang();
                                dh.input();
                                dh.nhapSpVaoDonHang(dssp);
                                dsdh.addDonHang(dh);
                                break;
                            case 2:
                                dsdh.output();
                                break;
                            case 3:
                                System.out.println("Kết thúc Crud Đơn Hàng!");
                                break;
                            default:
                                System.out.println("Nhập sai!. Vui lòng nhập lại");
                        }
                        if(chooseDH == 3) checkDH = false;
                    }while(checkDH == true);
                    break;
                case 4:
                    boolean checkBaoCao = true;
                    int chooseBaoCao;
                    do{
                        System.out.println("4.1 Hiển thị số lượng và tổng tiền sản phẩm");
                        System.out.println("4.2 Hiển thị top 3 sản phẩm bán chạy trong tháng");
                        System.out.println("4.3 Thoát");
                        System.out.println("Choose: ");
                        chooseBaoCao = Integer.parseInt(sc.nextLine());
                        switch (chooseBaoCao) {
                            case 1:
                                dsdh.output();;
                                dsdh.tongTien();
                                break;
                            case 2:
                                dsdh.timTopSanPham();
                                break;
                            case 3:
                                System.out.println("Kết thúc báo cáo!");
                                break;                               
                            default:
                                System.out.println("Nhập sai!. Vui lòng nhập lại");
                        }
                        if(chooseBaoCao == 3) checkBaoCao = false;
                    }while(checkBaoCao == true);
                    break;
                case 5:
                    System.out.println("Kết thúc!");
                    System.exit(1);
                default:
                    System.out.println("Nhập sai!. Vui lòng nhập lại");

            }
            if(functionID == 5) flag = false;
        }while(flag == true);
        sc.close();
    }
    public static void showMenu() {
        System.out.println("======= Quản Lý Bán Hàng =======");
        System.out.println("1. Crud Nhóm Hàng");
        System.out.println("2. Crud Sản Phảm");
        System.out.println("3. Crud Đơn Hàng");
        System.out.println("4. Báo cáo"); 
        System.out.println("5. Thoat");      
    }
}
