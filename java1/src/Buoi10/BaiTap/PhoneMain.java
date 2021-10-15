package java1.src.Buoi10.BaiTap;
public class PhoneMain {

	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		book.addPhone(new Phone("dung1", "0973999111"));
		book.addPhone(new Phone("dung2", "0973999112"));
		book.addPhone(new Phone("dung2", "0973999113"));
		book.addPhone(new Phone("dung2", "0973999114"));
		book.addPhone(new Phone("dung5", "0973999115"));
		book.showDanhBa();
		System.out.println(book.removePhoneByPhone("0973999115"));
		book.showDanhBa();
	}

}
