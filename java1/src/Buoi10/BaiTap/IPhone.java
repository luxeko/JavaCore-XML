package java1.src.Buoi10.BaiTap;

import java.util.ArrayList;

public interface IPhone {
	boolean addPhone(Phone phone);
	boolean removePhoneByName(String name);
	boolean removePhoneByPhone(String phone);
	boolean updatePhone(String name, String newPhone);
	ArrayList<Phone> searchPhone(String name, String phoneNumber);
	void sort();
}
