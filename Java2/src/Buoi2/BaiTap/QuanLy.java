package Java2.src.Buoi2.BaiTap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuanLy {
    void check(TaiKhoan taiKhoan){
        File file = new File("customer.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(taiKhoan.toString());
			
        } catch (IOException e) {
                e.printStackTrace();
        }finally{
            if(fw !=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Kết thúc ghi");
        Scanner sc = null;
		try {
			// b1: tao ket noi toi file vat ly
			sc = new Scanner(file);
			// b2: doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			
		}catch(IOException e) {
			System.out.println("File khong ton tai.");
		}
		// b3: giai phong ket noi toi file
		finally {
			if (sc != null) {
				sc.close();
			}
		}
		System.out.println("Doc xong file!");
    }
}
