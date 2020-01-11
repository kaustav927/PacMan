@SuppressWarnings("serial")
public class InexistentKeyException extends RuntimeException {
	public InexistentKeyException(String key) {
		super("The key: " + key +"does not exist.");
	}
}