package buoi3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		// collection: 1 phần tử là 1 đối tượng
		// add, size, contains, iterator, remove (object)
		
		// set:
		//main_Set();
		//main_Set_Object();
		// map: 1 phần tử là 1 cặp key - value, key khong trung nhau
		main_Map();
		// class Colections -> thao tac tren tap hop
	}
	public static void main_Map() {
		// key: ma san pham, tuong voi key co value: thong tin San pham
		Map<String, SanPham> mapSp = new HashMap<String, SanPham>();
		//Map<SanPhamMua, SanPham> mapSpMua = new HashMap<SanPhamMua, SanPham>();
		// them 1 phan tu vao map: put -> them moi khi key chua ton tai trong map
		mapSp.put("sp001", new SanPham("sp001", "Iphone 12", 20000f));
		System.out.println("1. Kich thuoc cua map: "+ mapSp.size());
		// put-> cap nhat value cua 1 phan tu vao map voi key da ton tai trong map
		mapSp.put("sp001", new SanPham("sp001", "Samsung note 8", 12000f));
		System.out.println("2. Kich thuoc cua map: "+ mapSp.size());
		mapSp.put("sp002", new SanPham("sp002", "Samsung plus 8", 8000f));
		mapSp.put("sp003", new SanPham("sp003", "Iphone 13", 23000f));
		
		// lay value cua 1 phan tu map: get
		SanPham sp = mapSp.get("sp001");
		System.out.println("Thong tin cua sp ma sp001: "+ sp);
		// check ton tai key trogn map: containsKey()
		System.out.println("Kiem tra xem map co key sp001: "+ mapSp.containsKey("sp001"));
		
		// duyet:
		// lay set keys: keySet();
		System.out.println("-------Duyet thong qua tap key cua map: ");
		Set<String> keySps = mapSp.keySet();
		for(String key : keySps) {
			System.out.println("Ma: "+ key + "; thong tin sp: "+ mapSp.get(key));
		}
		// duyet iterator: 
		System.out.println("-------Duyet Set<Map.Entry> ( 1 phan tu cua map): ");
		// chuyen doi 1 map -> set: entrySet, chuyen toi tu cap key - value -> 1 phan tu Set.Entry
		Set<Map.Entry<String, SanPham>> setMapSp = mapSp.entrySet();
		for(Map.Entry<String, SanPham> tmp : setMapSp) {
			System.out.println("Ma: "+ tmp.getKey() + "; thong tin sp: "+ tmp.getValue());
		}
	}
	public static void main_Set_Object() {
		Set<SanPhamMua> setProducts = new HashSet<SanPhamMua>();
		// ma hash: ma bam: la 1 so nguyen dai dien cho 1 doi tuong trong bo heap
		// lay ma hash -> hashCode ( Object)
		// 1 doi tuong (heap): dia chi (hexa), thong tin (thuoc tinh, hanh vi), hashCode: ma bam (int)
		SanPhamMua sp1 = new SanPhamMua("sp001", 2);
		SanPhamMua sp2 = new SanPhamMua("sp001", 1);
		System.out.println("sp1.equals(sp2) = " + sp1.equals(sp2));
		System.out.println("sp1.hashCode()= " + sp1.hashCode() + "; sp2.hashCode()= " + sp2.hashCode());
		
		System.out.println(setProducts.add(new SanPhamMua("sp001", 2)));
		System.out.println(setProducts.add(new SanPhamMua("sp001", 1)));
		System.out.println(setProducts.add(new SanPhamMua("sp002", 2)));
		System.out.println(setProducts.add(new SanPhamMua("sp003", 3)));
		System.out.println(setProducts.add(new SanPhamMua("sp002", 2)));
		System.out.println("Size products: "+ setProducts.size());
		
		Set<SanPhamMua> setOrderPriceDesc = new TreeSet<SanPhamMua>();
		setOrderPriceDesc.addAll(setProducts);
		System.out.println("Size ds sapxep: "+ setOrderPriceDesc.size());
		System.out.println("ds san pham theo sap xep giam dan so luong mua: ");
		Iterator<SanPhamMua> iteSort = setOrderPriceDesc.iterator();
		while(iteSort.hasNext()) {
			SanPhamMua sp = (SanPhamMua)iteSort.next();
			System.out.println(sp);
		}
		
	}
	public static void main_Set() {
		// set: tap hop chua cac phan tu khong theo thu tu ( khong co index ) va khong
		// trung nhau
		Set<String> setProducts = new HashSet<String>();
		// them -> add
		System.out.println(setProducts.add("sp005"));
		System.out.println(setProducts.add("sp004"));
		System.out.println(setProducts.add("sp003"));
		System.out.println(setProducts.add("sp001"));
		System.out.println(setProducts.add("sp001"));
		System.out.println(setProducts.add("sp002"));
		System.out.println(setProducts.add("sp002"));
		// kich thuoc -> size
		System.out.println("size set: " + setProducts.size());
		// xoa -> remove
		setProducts.remove("sp000");
		// duyet:
		//c1: foreach
		System.out.println("c1: foreach");
		for(String masp : setProducts) {
			System.out.print(masp + "  ");
		}
		System.out.println();
		// c2: iterator
		System.out.println("c2: iterator");
		Iterator<String> iteSet = setProducts.iterator();
		while(iteSet.hasNext()) {
			String tmp = iteSet.next();
			System.out.print(tmp + "  ");
		}
		System.out.println();
		// TreeSet: set co sap xep 
		Set<String> treeSetProducts = new TreeSet<String>();
		treeSetProducts.addAll(setProducts);
		System.out.println("TreeSet: ");
		Iterator<String> iteTreeSet = treeSetProducts.iterator();
		while(iteTreeSet.hasNext()) {
			String tmp = iteTreeSet.next();
			System.out.print(tmp + "  ");
		}
		System.out.println();
	}
	
	

	public static void main_List() {
		// list: tap hop chua phan theo thu tu -> index, co the trung nhau
		List<Integer> listNum = new ArrayList<Integer>();
		// them: add
		listNum.add(10);
		listNum.add(10);
		listNum.add(null);
		listNum.add(15);
		listNum.add(20);
		// lay ra 1 phan tu: -> get thong qua index
		listNum.get(0);
		// cap nhat -> set
		listNum.set(0, 100);
		// xoa -> remove
		listNum.remove((Object) 10);
		// kiem tra chua phan tu hay khong? -> contains
		listNum.contains(10);
		// kich co -> size()
		listNum.size();
		// duyet list:
		// c1: foreach -> collection
		System.out.println("c1: foreach -> collection");
		for (Integer tmp : listNum) {
			System.out.print(tmp + "  ");
		}
		System.out.println();
		// c2: -> for index -> list
		System.out.println("c2: -> for index -> list");
		for (int i = 0; i < listNum.size(); i++) {
			System.out.print(listNum.get(i) + "  ");
		}
		System.out.println();
		// c3: iterator -> collection
		System.out.println("c3: iterator -> collection");
		Iterator<Integer> iteList = listNum.iterator();
		while (iteList.hasNext()) {
			Integer tmp = iteList.next();
			System.out.print(tmp + "   ");
		}
		System.out.println();
		// c4: listierator -> list

		// lambda forEach()

		// stream

	}
}
