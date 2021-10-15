package Java2.src.Buoi5.BTVN.Bai2;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class checkThuMuc {
    private static final String FILE_BIN = "bin";
    private static final String FILE_Dat = "dat";
    public static void main(String[] args) {
        String fileName = "Java2\\src\\Buoi5\\BTVN\\Bai2";
        String fileNameCon = "Java2\\src\\Buoi5\\BTVN\\Bai2\\thumuc";
        File filePath = new File(fileName);
        System.out.println("File root là thư mục hay không? " + filePath.isDirectory());
        System.out.println("Duyệt thư mục");
        travelDirectory(filePath, 0);
        themThuMuc(filePath);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đuôi file: ");
        String duoi = sc.nextLine();
        timFile(fileNameCon, duoi);
        doiTen(fileNameCon , FILE_Dat);
        xoaBin(fileNameCon, FILE_BIN);
        inFile(filePath, 0);
    
    }
    public static void travelDirectory(File parent, int level){
        if(!parent.exists() )
            return;

        StringBuilder sb = new StringBuilder();
        //tính khoảng trắng trước file
        for(int i = 0; i < level; i++){
            sb.append("   ");
        }
        //dừng đệ quy
        //Khi file: flie chưa dữ liệu
        System.out.println(sb.toString() + (parent.isDirectory()?"-":"+") + ((level == 0)?parent.getAbsolutePath():parent.getName()));

        if(parent.isDirectory()){
            File [] dsFile = parent.listFiles();
            for(File f : dsFile){
                //gọi lại thao tác của chính nó
                travelDirectory(f, level + 1);
            }
        }
        
    }
    public static void themThuMuc(File parent){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên cho thư mục: ");
        String name = sc.nextLine();
        File newFile = new File(parent + "\\" + name);
        if(newFile.mkdir()){
            System.out.println("Tạo thư mục " + name + " thành công");
        }else{
            System.out.println("Tạo thư mục đã tồn tại!");
        }
    }
    public static void timFile(String folder, String ext){
        GenericExtFilter filter = new GenericExtFilter(ext);
        File dir = new File(folder);
        String[] list = dir.list(filter);
        if(list.length == 0){
            System.out.println("Không tồn tại file đuôi " + ext);
        }
        for(String file : list){
            String temp = new StringBuffer(folder).append(File.separator).append(file).toString();
            System.out.println("file : " + temp);
        }
    }
    public static void doiTen(String oldFile, String dat){
        GenericExtFilter filter = new GenericExtFilter(dat);
        File srcFile = new File(oldFile);
        String[] listDat = srcFile.list(filter);
        System.out.println("Danh sách file đuôi .dat: ");
        for (String path : listDat) {
            System.out.println(path);
            File tenCu = new File(oldFile +"\\" + path);
            String tenThemNew =  "new" + path;
            File tenMoi = new File(oldFile + "\\" + tenThemNew);
            if(tenCu.renameTo(tenMoi) == true){
                System.out.println("Đổi thành công");
            }else{
                System.out.println("Đổi thất bại");
            }
        } 
    }
    public static void xoaBin(String folder, String ext){
        GenericExtFilter filter = new GenericExtFilter(ext);
        File dir = new File(folder);
        String[] listBin = dir.list(filter);
        if(listBin.length == 0){
            System.out.println("Không tồn tại file đuôi .bin");
        }
        if(listBin.length != 0){
            File fileDelete;
            for (String file : listBin) {
                String temp = new StringBuffer(folder).append(File.separator)
                        .append(file).toString();
                fileDelete = new File(temp);
                fileDelete.delete();
                System.out.println("file : " + temp + " đã xoá thành công: " );
            }
        }
        
    }
    public static void inFile(File parent, int level){
        if(!parent.exists() )
            return;

        StringBuilder sb = new StringBuilder();
        //tính khoảng trắng trước file
        for(int i = 0; i < level; i++){
            sb.append("   ");
        }
        //dừng đệ quy
        //Khi file: flie chưa dữ liệu
        System.out.println(sb.toString() + (parent.isDirectory()?"-":"+") + ((level == 0)?parent.getAbsolutePath():parent.getName()));

        if(parent.isDirectory()){
            File [] dsFile = parent.listFiles();
            for(File f : dsFile){
                //gọi lại thao tác của chính nó
                travelDirectory(f, level + 1);
            }
        }
    }
    public static class GenericExtFilter implements FilenameFilter {
        private String ext;
        public GenericExtFilter(String ext) {
            this.ext = ext;
        }
        public boolean accept(File dir, String name) {
            return (name.endsWith(ext));
        }
    }
}
