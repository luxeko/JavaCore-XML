package java1.src.Buoi6;

import java.util.Scanner;

public class ArrayMotChieu {
   public static void main(String[] args){
      // //Khai bao mang
      // int [] numb;

      // //gan gia tri bien mang
      // numb = new int[5];
      // System.out.println("Kich thuoc cua mang: " + numb.length);
      // System.out.println("numb[0] = " + numb[0]);
     
      Scanner sc = new Scanner(System.in);
      // System.out.println("Nhap cac phan tu mang: " );
      // int i = 0;
      // do{
      //    System.out.println("numb[" + i + "] = ");
      //    numb[i++] = sc.nextInt();
      //    //i++
      // }while (i < numb.length);

      // //duyet mang;
      // System.out.println("Duyet mang cach 1 for/while/do while: ");
      // for(i = 0; i < numb.length; i++){
      //    System.out.printf("%d ", numb[i]);
      // }

      // System.out.println("\nDuyet mang cach 2 foreach: ");
      // for(int temp : numb){
      //    System.out.printf("%d ", temp);
      // }

      String[] names = new String[16];
      // System.out.println("\nKich thuoc cua mang 2: " + names.length);
      // System.out.println("names[0] = " + names[0]);

      //nhap cac ten hoc sinh trong names, chon tiep tuc thi nhap phan tu tiep theo
      //in danh sach ten cac hoc sinh (!= null) trong lop

      System.out.println("Nhap ten cac hoc vien: ");
      int j = 0;
      String confirm = "" ;
      do{
         System.out.println("name[ " + j + "] = ");
         names[j++] = sc.nextLine();
         System.out.println("Chon tiep tuc? (no: Stop)");
         confirm = sc.nextLine();
      }while(j < names.length && !confirm.equalsIgnoreCase("no"));

      for(String ten : names){
         if (ten != null){
            System.out.printf(" \n%s ", ten);
         }
      }
      System.out.println("\nDuyet cac phan tu != null: ");
      for(int k = 0; k < j; k++){
         System.out.printf( " %s ", names[k]);
      }

      // float [] points = {10, 5.5f, 7, 8.5f};
      // System.out.println("Kich thuoc cua mang 3: " + points.length);
      // System.out.println("points[0] = " + points[3]);
      sc.close();
   }
}
