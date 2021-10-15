package java1.src.Buoi11.BTVN.Bai2;

import java.io.FileNotFoundException;

public class main {
    public static void Main(String[] args) throws FileNotFoundException {
        SinhVien sv = new SinhVien();
        sv.readFile();
        SinhVien.printInfo();
    }
}
