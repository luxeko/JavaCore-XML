package baitapinterface;

import java.util.ArrayList;

public class PhoneBook implements IPhone{
	private ArrayList<Phone> danhBa = new ArrayList<Phone>();
	
	/*
	 * phone ma hop le -> true, nguoc lai: false
	 * */
	private boolean validatePhone(Phone phone) {
		if (phone == null)
			return false;
		for (Phone p : this.danhBa) {
			if (p.getPhoneNumber().equals(phone.getPhoneNumber())) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean addPhone(Phone phone) {
		if (this.validatePhone(phone)) {
			this.danhBa.add(phone);
			return true;
		}
		return false;
	}

	@Override
	public boolean removePhoneByName(String name) {
		// hieu
		// list phone cung name listPhoneByName
		ArrayList<Phone> listByName = this.searchPhone(name);
		
		// duyet listPhoneByName xoa trong danhBa
		if (listByName.size() > 0) {
			for (Phone p : listByName) {
				this.danhBa.remove(p);
			}
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removePhoneByPhone(String phoneNumber) {
		// duc anh
		//for(Phone p: this.danhBa) {
		for (int i=0; i< this.danhBa.size(); i++) {
			Phone p = this.danhBa.get(i);
			if(p.getPhoneNumber().equals(phoneNumber)) {
				this.danhBa.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePhone(String name, String newPhone) {
		// ngoc thien
		ArrayList<Phone> listByName = this.searchPhone(name);
		if (listByName.size() > 0) {
			int index = this.danhBa.indexOf(listByName.get(0));
			Phone p = listByName.get(0);
			p.setPhoneNumber(newPhone);
			this.danhBa.set(index, p);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Phone> searchPhone(String name) {
		// minh luu
		ArrayList<Phone> result = new ArrayList<Phone>();
		for(Phone p : this.danhBa) {
			if (p.getName().equals(name)) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
	}
	public void showDanhBa() {
		System.out.println("------Danh ba---------");
		for(Phone p : this.danhBa) {
			p.xuat();
		}
	}
}
