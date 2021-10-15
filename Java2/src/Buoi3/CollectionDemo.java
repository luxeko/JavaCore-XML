package Java2.src.Buoi3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {
    public static void main(String[] args) {
        //collection: 1 phần tử là 1 đối tượng
        //add, size, contains, iterator, remove
        //main_set();
        main_Set_Bbject();;
        
        //map: 1 phan tu la 1 cap ky - value
        //main_map();
        //class Collections -> thao tac tren tap hop
    }
    public static void main_map() {
        //key se la ma san pham, tuong ung voi key co value: thong tin san pham
        Map<String, SanPham> mapSp = new HashMap<String, SanPham>();
        //Map<SanPhamMua, SanPham> mapSpMua = new HashMap<SanPhamMua, SanPham>();

        //them 1 phan tu vao map: put(thêm mới khi key chưa tồn tại trong map)
        mapSp.put("sp001", new SanPham("sp001", "Iphone12", 20000f));
        System.out.println("Kich thước của map khi put lần 1: " + mapSp.size());
        mapSp.put("sp001", new SanPham("sp002", "SamSung", 180000f));
        System.out.println("Kich thước của map khi put lần 2: " + mapSp.size());
        //=> khi key đã tồn tại thì put đóng vai trò là cập nhật value của phần tử của phần tử đó
        mapSp.put("sp002", new SanPham("sp002", "Nokia", 100000f));
        mapSp.put("sp003", new SanPham("sp003", "Sony", 120000f));

        //lấy value cỉa 1 phần tử map: get
        System.out.println("Thông tin của sp mã sp001: " + mapSp.get("sp001"));
        //check tồn tại key trong map: containsKey()
        System.out.println("Kiểm tra xem map có key sp sp001: " + mapSp.containsKey("sp001"));

        //duyệt:
        //lấy set keys: keySet();
        System.out.println("------ Duyệt forech bình thường của map ------");
        Set<String> keySps = mapSp.keySet();
        for(String key : keySps){
            System.out.println("Mã: " + key + "; thông tin sản phẩm: " + mapSp.get(key));
        }


        //duyet kiểu chuyển Map sang Set:
        System.out.println("Duyệt theo kiểu chuyển từ map sang set: ");
        //chuyển đổi 1 map -> set: entrySet, chuyển đổi từ 1 cặp key-value sang 1 phần tử Set.Entry
        Set<Map.Entry<String, SanPham>> setMapSp =  mapSp.entrySet();
        System.out.println("------ Duyệt Iterator ------");
        Iterator<Map.Entry<String, SanPham>> iteratorMap = setMapSp.iterator();
        while(iteratorMap.hasNext()){
            Map.Entry<String, SanPham> sp = iteratorMap.next();
            System.out.println("Mã: " + sp.getKey() + "; thông tin sp: " + sp.getValue());
        }System.out.println();
        System.out.println("------ Duyệt forech theo kiểu chuyển sang set ------");
        for(Map.Entry<String, SanPham> tmp : setMapSp){
            System.out.println("Mã: " + tmp.getKey() + "; thông tin sp: " + tmp.getValue());
        }
        
    }
    public static void main_Set_Bbject() {
        Set<SanPhamMua> setProducts = new HashSet<SanPhamMua>();
        //ma Hash: hay còn gọi là mã băm là 1 số nguyên đại diện cho 1 đối tượng trong bộ heap
        //lấy mã hash -> hashCode(Object)
        SanPhamMua sp1 = new SanPhamMua("sp001", 2);
        SanPhamMua sp2 = new SanPhamMua("sp001", 1);
        System.out.println("" + sp1.equals(sp2));
        System.out.println("sp1.hashCode() = " + sp1.hashCode() + " ; sp2.hashCode() = " + sp2.hashCode());
        System.out.println(setProducts.add(new SanPhamMua("sp004", 2)));
        System.out.println(setProducts.add(new SanPhamMua("sp001", 2)));
        System.out.println(setProducts.add(new SanPhamMua("sp001", 1))); 
        System.out.println(setProducts.add(new SanPhamMua("sp002", 2))); 
        System.out.println(setProducts.add(new SanPhamMua("sp003", 3)));
        System.out.println(setProducts.add(new SanPhamMua("sp002", 2)));
        

        Set<SanPhamMua> setOrderPrice = new TreeSet<SanPhamMua>();
        setOrderPrice.addAll(setProducts);
        System.out.println("Size ds sap xep: " + setOrderPrice.size());
        for(SanPhamMua spM : setOrderPrice){
            System.out.println(spM);
        }System.out.println();

        Iterator<SanPhamMua> iteSort = setOrderPrice.iterator();
        while(iteSort.hasNext()){
            SanPhamMua sp = (SanPhamMua) iteSort.next();
            System.out.println(sp);
        }
            
        
    }
    public static void main_set() {
        //set: tap hop cac phan tu ko theo thu tu (nen ko co index) va khong trung nhau
        Set<String> setProducts = new HashSet<String>();
        //them: add
        System.out.println(setProducts.add("sp005"));
        System.out.println(setProducts.add("sp004"));
        System.out.println(setProducts.add("sp003"));
        System.out.println(setProducts.add("sp001"));
        System.out.println(setProducts.add("sp001"));
        System.out.println(setProducts.add("sp002"));
        System.out.println(setProducts.add("sp002"));
        //kick thuoc -> size
        System.out.println("size set: " + setProducts.size());
        //xoa -> remove
        setProducts.remove("sp000");
        // duyet set:
        //C1: foreach
        System.out.println("Duyet C1: foreach");
        for(String masp : setProducts){
            System.out.print(masp + " ");
        }System.out.println();
        //C2: for theo index tuong tu list
        //C3: iterator tuong tu
        //C4: listiterator tuong tu

        //Treeset: set co sap xep
        Set<String> treeSetProducts = new TreeSet<String>();
        treeSetProducts.addAll(setProducts);
        System.out.println("Sap xep set theo thu tu");
        for(String masp : treeSetProducts){
            System.out.print(masp + " ");
        }System.out.println();
    }
    

    public static void main_list() {
        //list: tap hop cac phan tu theo thu tu -> index, co the trung nhau
        List<Integer> listNum = new ArrayList<Integer>();
        //them: add
        listNum.add(10);
        listNum.add(10);
        listNum.add(null);
        listNum.add(10);
        listNum.add(15);
        listNum.add(20);
        //lay ra 1 phan tu: -> get thong qua index
        listNum.get(0);
        //cap nhat -> set
        listNum.set(0, 100);
        //xoa -> remove
        //listNum.remove(1); // remove theo index
        listNum.remove((Object) 10); //remove theo gia tri
        //kiem tra phan tu cos ton tai hay ko?
        listNum.contains(10);
        //kick co -> size
        listNum.size();
        //duyet list:
        //c1: foreach -> dung cho tat ca collection(bao gom list, set, queue)
        for(Integer tmp : listNum){
            System.out.print(tmp + " ");
        }
        System.out.println();
        //c2: for index -> cho list
        for(int i = 0; i < listNum.size(); i++){
            System.out.print(listNum.get(i) + " ");
        }
        System.out.println();
        //c3: iterator -> dung cho tat ca collection
        Iterator<Integer> ite = listNum.iterator();
        while(ite.hasNext()){
            Integer tmp = ite.next();
            System.out.print(tmp + " ");
        } 
        System.out.println();
        //c4: listiterator -> cho list
        ListIterator<Integer> listIte = listNum.listIterator();
        while(listIte.hasNext()){
            Integer tmp = listIte.next();
            System.out.print(tmp + " ");
        }
        System.out.println();
        // cach khac sau nay hoc: lambda forEach()
        //cach khac: dung stream
    }
}
