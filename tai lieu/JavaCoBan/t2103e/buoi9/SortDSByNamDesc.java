package buoi9;

import java.util.Comparator;

import buoi8.Nguoi;
// tao ra 1 quy tac sap xep
public class SortDSByNamDesc implements Comparator<Nguoi>{

	@Override
	public int compare(Nguoi o1, Nguoi o2) {
		// TODO Auto-generated method stub
		// sap xep giam dan thi lay o2 so sanh voi o1
		// sap xep tang dan thi lay o1 so sanh voi o2
		if (o1 == null || o2 == null)
			return 0;
		return o2.getTen().compareTo(o1.getTen());
	}

}
