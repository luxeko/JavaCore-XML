package Java2.src.Buoi5.BTVN.Bai1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class dsDanhBa {
    private static ArrayList<danhBa> dsDb;

    public dsDanhBa() {
        dsDb = new ArrayList<danhBa>();
    }
    public static ArrayList<danhBa> getDsDb() {
        return dsDb;
    }

    public static void setDsDb(ArrayList<danhBa> dsDb) {
        dsDanhBa.dsDb = dsDb;
    }
    public static boolean addDanhBa(danhBa db){
        if(db == null)
            return false;
        else{
            dsDb.add(db);
            return true;
        }
    }
    public void inDanhBaArr(){
        for(danhBa db : dsDb){
            System.out.println(db.toString());
        }
    }

    //saiiiiiiiiiii
    public void luuDanhBa(String fileName) {
        File file = new File(fileName);
        try(Scanner sc = new Scanner(file)) {
            System.out.println("Thêm thành công");
            while (sc.hasNext()) {
                String line = sc.nextLine();
                danhBa dB = validateLineDB(line);
                dsDb.add(dB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static danhBa validateLineDB(String line){
        String[] arrLine = line.split("\n");
		for(String st : arrLine){
			System.out.println(st);
		}
        return null;
    }
    public void timSDT() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần tìm: ");
        String timkiem = sc.nextLine();
        while(true){
            int cout = 0;
            for(danhBa dB : dsDb){
                if(timkiem.equalsIgnoreCase(dB.getPhoneNumber())){
                    System.out.println(dB.toString());
                    cout++;
                    break;
                }
            }if(cout == 0){
                System.out.println("SDT không tồn tại!");
                break;
            } 
        }
    } 
    public void xoaFile(String fileName){
        try {
            File file = new File (fileName);
            if (file.delete()) {
                System.out.println("Xoá file thành công");
            } else {
                System.out.println("Xoá file thất bại");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
