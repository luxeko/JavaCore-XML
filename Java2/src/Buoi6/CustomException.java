package Java2.src.Buoi6;

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
		return this.message;
	}
}
