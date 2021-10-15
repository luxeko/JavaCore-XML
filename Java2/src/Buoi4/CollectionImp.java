package Java2.src.Buoi4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class CollectionImp{
    /**
     * Tạo 1 list các số nguyên, thêm 50 số nguyên sinh ngẫu nhiên ( số < 10 ) List.
     * - Hiển thị danh sách các số nguyên không trùng từ List trên
     * - Hiển thị ds các số nguyên ko trùng và số lần xuất hiện
     * - sắp xếp ds List
     * - sắp danh sách Set
     * - sắp xếp map
     * - sắp xếp Key
     * - sắp xếp value
     */ 

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 50; i++){
            //tạo 1 số nguyên ngẫu nhiên trong khoảng 0 -> 10
            int num = rand.nextInt(10); 
            list.add(num);
        }
        System.out.println("Hiển thị danh sách list: ");
        showDs(list);

        //tao ds cac tap so nguyen khong trung nhau trong list
        Set<Integer> set = new HashSet<Integer>(list);
        System.out.println("Danh sách các phần từ khi xoá trùng nhau");
        showDs(set);

        //tu list: sap xep so chan theo quy tac giam dan
        //sap xep so le theo quy tang tang dan
        //collections: class thao tac tren tap danh sach, sap xep, xao tron, copy...
        Collections.sort(list, new tangDanComparator());
        System.out.println("Danh sách sắp xếp: ");
        showDs(list);


        //chuyen doi 1 list -> map:<key: phan tu ko trung trong list, value: so lan xuat hien cua phan tu trong map>
        Map<Integer, Integer> mapSoNguyen = new HashMap<Integer, Integer>(); 
        for(int num : list){
            if(mapSoNguyen.containsKey(num)){
                //cap nhat lai gia tri
                mapSoNguyen.put(num, mapSoNguyen.get(num)+1);
            }else{
                //them moi gia tri
                mapSoNguyen.put(num, 1);
            }
        }

        //duyet map
        //từ map chuyển sang collection
        System.out.println("Hiển thị danh sách phần tử và số lần xuất hiện");
        showMap(mapSoNguyen);

        //sap xep map
        //sap xep theo key
        //mặc định tăng dần
        TreeMap<Integer, Integer> sapxepTangDanKey = new TreeMap<Integer, Integer>(new tangDanComparator());
        sapxepTangDanKey.putAll(mapSoNguyen);
        System.out.println("Hiển thị ds phần tử tang dần theo key: ");
        showMap(sapxepTangDanKey);        

        //sap xep cac phan tu va so luong xuat hien giam dan, nếu số lượng bằng nhau thì tăng dần theo key
        Comparator<Integer> giamDanValueComparator = new giamDanValueComparator(mapSoNguyen);
        TreeMap<Integer, Integer> sapXepGiamDanValue = new TreeMap<Integer, Integer>(giamDanValueComparator);
        sapXepGiamDanValue.putAll(mapSoNguyen);
        System.out.println("Hiển thị ds phần tử map: gảim dần theo value, nếu trùng value thì tăng theo key: ");
        showMap(sapXepGiamDanValue);


    }

    public static void showDs(Collection<Integer> danhSach) {
        for(int num : danhSach){
            System.out.print(num + " ");
        }System.out.println("");
    }
    public static void showMap(Map<Integer, Integer> map){
        Set<Map.Entry<Integer, Integer>> setEntry =  map.entrySet();
        for(Map.Entry<Integer, Integer> item : setEntry){
            System.out.println((item.getKey()) + " số lần xuất hiện: " + item.getValue());
        }
    }
    
}
class giamDanValueComparator implements Comparator<Integer>{
    private Map<Integer, Integer> map;
    
    public giamDanValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(Integer o1, Integer o2) {
        //giá trị bằng nhau, tằng dần theo key(key ko bao giờ trùng nhau nên return luôn khác 0)
        if(map.get(o1) == map.get(o2))
            //return -1;
            return o1.compareTo(o2);
        return map.get(o2).compareTo(map.get(o1));
    }
}

class tangDanComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1%2==0){
            o1 *= -1;
        }
        if(o2%2==0){
            o2*=-1;
        }
        return o1.compareTo(o2);
    }
}
