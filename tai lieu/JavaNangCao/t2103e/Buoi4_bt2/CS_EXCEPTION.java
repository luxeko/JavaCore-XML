package Buoi4_bt2;

public class CS_EXCEPTION extends Exception {
	private String message;

	public CS_EXCEPTION(String message) {
		super();
		this.message = message;
	}

	public CS_EXCEPTION() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.message;
	}
	
	
}
