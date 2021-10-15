package Java2.src.Buoi3.BTVN.Bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class arrayList {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<Integer>();
        int n;
        int number;
        int functionID;
        int index;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        do{
            try {
                System.out.println("Nhập số lượng phần từ trong Arraylist: ");
                n = Integer.parseInt(sc.nextLine());
                for(int i = 0; i < n; i++){
                    try {
                        System.out.println("Nhập phần tử thứ " + i + ": ");
                        number = Integer.parseInt(sc.nextLine());  
                        arrList.add(number);
                        flag = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Phần tử phải là kiểu số");
                    }             
                }
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là kiểu số");
            }
        }while (flag == true);
        
        do{ 
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                //Duyet mang bang vong lap for
                case 1:
                    System.out.println("Danh sách các phần tử trong mảng: ");
                    for(int i = 0; i < arrList.size(); i++){
                        System.out.print(arrList.get(i) + " ");
                    }System.out.print("\n");
                    break;
                //Duyet mang bang foreach
                case 2:
                    System.out.println("Danh sách các phần tử trong mảng: ");
                    for(int each : arrList){
                        System.out.print(each + " ");
                    }System.out.print("\n");
                    break;
                //Duyet mang bang Iterator
                case 3:
                    Iterator<Integer> ite = arrList.iterator();
                    System.out.println("Danh sách các phần tử trong mảng: ");
                    while(ite.hasNext()){
                        System.out.print((Integer) ite.next() + " ");
                    }System.out.print("\n");
                    break;
                //Duyet mang bang ListIterator
                case 4:
                    ListIterator<Integer> listIte = arrList.listIterator();
                    System.out.println("Danh sách các phần tử trong mảng: ");
                    while(listIte.hasNext()){
                        System.out.print((Integer) listIte.next() +" ");
                    }System.out.print("\n");
                    break;
                //Xoa bo cac phan tu trung nhau
                case 5:
                    System.out.println("Xoá bỏ các phần tử trùng nhau trong Arraylist");
                    Set<Integer> set = new HashSet<Integer>(arrList);
                    List<Integer> arrListNoDupLiCaTe = new ArrayList<Integer>(set);
                    System.out.println("Danh sách các phần từ khi xoá trùng nhau");
                    System.out.println(arrListNoDupLiCaTe);
                    break;
                    
                //Hien thi chi so index cua phan tu
                case 6:
                    System.out.println("Hiển thị chỉ số index của phần tử");
                    System.out.println("Nhập phần tử: ");
                    int check = Integer.parseInt(sc.nextLine());
                    int indexCheck = arrList.indexOf(check);
                    if(arrList.contains(check)){
                        System.out.println(indexCheck);
                    }else{
                        System.out.println("Phần tử không tồn tại");
                    }
                    
                    break;
                
                //Tim so lan xuat hien cua phan tu
                case 7:
                    int count = 0;
                    System.out.println("Nhập phần tử: ");
                    index = Integer.parseInt(sc.nextLine());
                    for(int i = 0; i < arrList.size(); i++){
                        if(index == arrList.get(i)){
                            System.out.println(index + " ở vị trí: " + (arrList.get(i)-1));
                            count++;
                            break;
                        }
                    }if(count == 0){
                        System.out.println("Phần tử không tồn tại!");
                    }
                    break;

                //Dao nguoc va xao tron
                case 8:
                        ListIterator<Integer> li = arrList.listIterator(arrList.size());
                        System.out.println("Dao nguoc cac phan tu: ");
                        while(li.hasPrevious()) {
                            System.out.print(li.previous() + " ");
                        }
                
                        Collections.shuffle(arrList);
                        System.out.println("");
                        System.out.println("Xao tron cac phan tu: " + arrList);
                    break;
                case 9: 
                    System.out.println("Kết thúc!");
                    System.exit(1);
                default:
                    System.out.println("Nhập không đúng lựa chọn");
            }
            if(functionID == 9) flag = false;
        }while(flag = true);
        sc.close();
    }

    public static void showMenu() {
        System.out.println("======= Các cách duyệt mảng =======");
        System.out.println("1. Cách 1: Dùng for");
        System.out.println("2. Cách 2: Dùng foreach");
        System.out.println("3. Cách 3: Dùng Iterator");
        System.out.println("4. Cách 3: Dùng ListIterator");
        System.out.println("5. Bỏ các thành phần trùng nhau");  
        System.out.println("6. Hiển thị số lần xuất hiện của phần tử"); 
        System.out.println("7. Nhập 1 số từ bàn phím, hiển thị các chỉ số (index) của phần tử ấy trong mảng"); 
        System.out.println("8. Đảo ngược và xáo trộn mảng sử dụng Collections."); 
        System.out.println("9. Thoát");

    }
    
}
