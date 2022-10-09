package baitapinterface;

public class PhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook book = new PhoneBook();
		System.out.println(book.removePhoneByName("dung2"));
		book.addPhone(new Phone("dung1", "0973999111"));
		book.addPhone(new Phone("dung2", "0973999112"));
		book.addPhone(new Phone("dung2", "0973999113"));
		book.addPhone(new Phone("dung2", "0973999114"));
		book.addPhone(new Phone("dung5", "0973999115"));
		book.showDanhBa();
		System.out.println(book.removePhoneByName("dung2"));
		book.showDanhBa();
	}

}
