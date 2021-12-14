package Java2.src.Buoi5.BTVN.Bai1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void Main(String[] args) {
        dsDanhBa dsDB = new dsDanhBa();
        String fileName = "E:\\Java\\Java2\\src\\Buoi5\\BTVN\\Bai1\\danhba.txt";
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        do {
            danhBa dB = new danhBa();
            showMenu();
            System.out.println("Nhập lựa chọn: ");
            functionID = Integer.parseInt(sc.nextLine());
            switch (functionID) {
                case 1://thêm 1 danh bạ vào file
                    dB.input();
                    appendLineToFile(fileName, dB);
                    break;
                case 2://Hiển thị nội dung file của danh bạ
                    readFile(fileName);
                    break;
                case 3://Lưu danh bạ vào arraylist
                    dsDB.luuDanhBa(fileName);
                    dsDB.inDanhBaArr();
                    break;
                case 4://Tìm danh bạ theo sdt
                    dsDB.timSDT();
                    break;
                case 5://Xoá file danh bạ
                    dsDB.xoaFile(fileName);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình");
                    System.exit(1);
                    break;

                default:
                    System.out.println("Nhập sai lựa chọn! Vui lòng nhập lại");
            }
            if(functionID == 6) flag = false;
        } while (flag == true);
    }
    public static void showMenu(){
        System.out.println("====== Quản lý danh bạ ======");
        System.out.println("1. Thêm danh bạ");
        System.out.println("2. Hiển thị nội dung file của danh bạ");
        System.out.println("3. Lưu danh bạ vào mảng ArrayList");
        System.out.println("4. Tìm danh bạ theo SDT"); 
        System.out.println("5. Xoá file danh bạ");      
        System.out.println("6. Thoát");
    }
    public static void appendLineToFile(String fileName, danhBa dB) {
        File file = new File(fileName);
        FileWriter fr = null;
		if (dB == null) {
			System.out.println("Danh bạ trống");
		}
		try{
            fr = new FileWriter(file, true);
			fr.write(dB.toString());
			System.out.println("Thêm danh bạ thành công");
		}catch(IOException e) {
			System.out.println("Không tìm thấy file");
		}finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
    public static void readFile(String fileName){
        ArrayList<danhBa> result = new ArrayList<danhBa>();
        File file = new File(fileName);
        try(Scanner sc = new Scanner(file)){
			// doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				// validate line va chuyen line -> TaiKhoan
				danhBa dB = validateLineDB(line);
				if (dB != null) {
					result.add(dB);	
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
    }
    private static danhBa validateLineDB(String line){
        String[] arrLine = line.split("\n");
		for(String st : arrLine){
			System.out.println(st);
		}
        return null;
    }
}
