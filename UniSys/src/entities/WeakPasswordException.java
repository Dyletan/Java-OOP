package entities;

public class WeakPasswordException extends Exception {
	/**
	 * 
	 * @param string message that we want to print when exception work
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}
