package java1.src.Buoi9;

import java.util.Comparator;

import java1.src.Buoi8.Nguoi;

//Tao ra 1 quy tac sap xep
public class SortDSByNameDesc implements Comparator<Nguoi> {

    @Override
    public int compare(Nguoi o1, Nguoi o2) {
        //Sap xep giam dan thi lay o2 so voi o1
        //Sap xep tang dan thi lay o1 so voi o2
        if(o1 == null || o2 == null)
            return 0;
        return o2.getTen().compareTo(o1.getTen());
    }
    
    
}
