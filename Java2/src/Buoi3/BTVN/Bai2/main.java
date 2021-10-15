package Java2.src.Buoi3.BTVN.Bai2;

import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        String ten;
        String maNganh;
        dsSinhVien dssv = new dsSinhVien();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1://tạo đối tượng sv và thêm vào danh sách
                    sinhVien sv = new sinhVien();
                    sv.input(dssv);
                    dssv.addSV(sv);
                    break;
                case 2://Sắp xếp danh sách sinh viên theo tăng dần tên và mã ngành học
                    dssv.printSV();
                    break;
                case 3://Hiển thị danh sách sinh viên không trùng tên
                    dssv.tenSvKhongTrung();
                    break;
                case 4://Hiển thị sinh viên tìm kiếm theo tên hoặc mã ngành
                    while(true){
                        System.out.println("Nhập tên sinh viên: ");
                        ten = sc.nextLine();
                        if(ten.trim().equals("")){
                            System.out.println("Bạn chưa nhập tên");
                        }else{
                            System.out.println("Nhập mã ngành: ");
                            maNganh = sc.nextLine();
                            if(maNganh.trim().equals("")){
                                System.out.println("Bạn chưa nhập mã ngành");
                            }else{
                                break;
                            }
                        }
                    }
                    dssv.timSV(ten, maNganh);
                    break;
                case 5://Xoá sinh viên khi nhập tên và mã ngành học
                    while(true){
                        System.out.println("Nhập tên sinh viên: ");
                        ten = sc.nextLine();
                        if(ten.trim().equals("")){
                            System.out.println("Bạn chưa nhập tên");
                        }else{
                            System.out.println("Nhập mã ngành: ");
                            maNganh = sc.nextLine();
                            if(maNganh.trim().equals("")){
                                System.out.println("Bạn chưa nhập mã ngành");
                            }else{
                                break;
                            }
                        }
                    }
                    dssv.xoaSV(ten, maNganh);
                    break;
                case 6://Hiển thị số lượng sinh viên theo từng độ tuổi
                    dssv.tinhTuoi();
                    break;
                case 7:
                    System.out.println("Kết thúc!");
                    System.exit(1);
                default:
                    System.out.println("Nhập sai!. Vui lòng nhập lại");

            }
            if(functionID == 7) flag = false;
        }while(flag == true);
        sc.close();
    }
    public static void showMenu() {
        System.out.println("======= Quản Lý Sinh Viên =======");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sắp xếp sinh viên theo thứ tự tăng dần tên và mã ngành học");
        System.out.println("3. Hiển thị sinh viên không trùng nhau");
        System.out.println("4. Tìm sinh viên theo tên hoặc mã ngành"); 
        System.out.println("5. Xoá khi nhập tên hoặc mã ngành");      
        System.out.println("6. Hiển thị sinh viên theo từng độ tuổi và thông tin sắp xếp theo độ tuổi");
        System.out.println("7. Thoát");
    }
    
}
