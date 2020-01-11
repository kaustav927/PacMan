@SuppressWarnings("serial")
public class EmptyTreeException extends RuntimeException {
	public EmptyTreeException(String string) {
		super("The Binary Search Tree is Empty."); 
	}
}