package java1.src.Buoi11;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowDemo {
    private ArrayList<String[]> listValidBook = new ArrayList<String[]>();
    public static void main(String[] args)  {
        System.out.println("Step 1");
      
        try {
            ThrowDemo.validateCheckedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FileLockInterruptionException e) {
            e.printStackTrace();
        }

        // try{
        //     ThrowDemo.validateUnCheckedException(null);
        // }catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
        System.out.println("Step End");
    }
    //Doc file
    //Throws: Khai bao cac loai ngoai le co kha nang xay ra khi ham runtime
    public static void validateCheckedException() throws FileNotFoundException, FileLockInterruptionException {
        //Duong dan tuyet doi
        // File file = new File("E:\\Java\\Buoi3\\dsbook.txt");
        //Duong dan tuong doi
        File file = new File("dsbook.txt");
        Scanner sc = new Scanner(file);
        //doc file
        while(sc.hasNext()){
            String line = sc.nextLine();
            try {
                validateUnCheckedException(line);
                System.out.println(line + " -> Ok ");
            } catch (Exception e) {
                System.out.println(line + " -> Not ok " + e.getMessage());
            }
        }
        System.out.println("Ok");sc.close();
    }


    //validate 1 hang du lieu dung tuong ung voi 1 quyen sach
    //b001, Cuon theo chieu gio, 120000, DA
    //mang 4 phan tu, phan tu th3: gia phai la so nguyen duong
    public static void validateUnCheckedException(String input) {
        /**
         * - du lieu dau vao
         * - chuyen doi kieu: parse, format
         * - ep kieu: cast
         * - index: array, collection
         * - null
         */
        // check validate sodienthoai
        //throw: nem 1 doi tuong ngoai le cu the ra chuong trinh

        if(input == null){
            throw new NullPointerException("Input is empty");
        }
        String[] arr = input.split(", ");
        if(arr.length == 4){
            //du lieu tam ok
            String s_prive = arr[2];
            try{
                Long price = Long.parseLong(s_prive);
            }catch(Exception e){
                throw new InputMismatchException("Price is not number");
            }
        }else{
            //du lieu sai hoac thieu
            throw new ArrayIndexOutOfBoundsException("Input is not enough");
        }        
    }
    
}
