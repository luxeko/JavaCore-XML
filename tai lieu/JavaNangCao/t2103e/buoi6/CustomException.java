package buoi6;

public class CustomException extends Exception{
	private String message;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.message;
	}
}
