package Java2.src.Buoi2.BaiTap;


import java.util.Scanner;

public class main {

    public static void Main(String[] args) {
        // QuanLy qly = new QuanLy();
        // tk.input();
        // tk.output();
        // qly.check(tk);
        dsTaiKhoan dstk = new dsTaiKhoan();
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        do{
            TaiKhoan taiKhoan = new TaiKhoan();
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    taiKhoan.input();
                    dsTaiKhoan.addANew(taiKhoan);
                    break;
                case 2:
                    dstk.inRaTK();
                    break;
                case 3:
                    dstk.findTk();
                    break;
                case 4:
                    dstk.napTien();
                    break;
                case 5: 
                    dstk.rutTien();
                    break;
                case 6: 
                    dsTaiKhoan.readFile("customer.txt");
                    break;
                case 7: 
                    //tim doi tuong tk theo ma
                    taiKhoan.input();
                    dsTaiKhoan.appendLineToFile("luuDsTk.txt", taiKhoan);
                    break;
                case 8:
                    dsTaiKhoan.resetFile("customer.txt");
                    break;
                case 9:
                    System.out.println("Kết thúc!");
                    System.exit(1);
                default:
                    System.out.println("Nhập không đúng lựa chọn");
            }
            if(functionID == 9) flag = false;
        }while(flag == true);
        sc.close();
    }
    public static void showMenu() {
        System.out.println("======= Manage =======");
        System.out.println("1. Thêm 1 tài khoản vào ds");
        System.out.println("2. Hiển thị ds tài khoản");
        System.out.println("3. Tim số tk theo mã kh hoặc sotk");
        System.out.println("4. Gửi tiền");
        System.out.println("5. Rút tiền");     
        System.out.println("6. Đọc dữ liệu từ 1 file txt");   
        System.out.println("7. Ghi thông tin tk mới vào file");   
        System.out.println("8. Reset danh sách và chuyển các tài khoản hợp lệ vào ds");     
        System.out.println("9. Thoát");     
    }
}
