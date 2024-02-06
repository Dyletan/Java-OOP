package entities;

public class PasswordsDoNotMatchException extends Exception {
	/**
	 * 
	 * @param string message that we want to print when exception work
	 */
	public PasswordsDoNotMatchException(String message) {
		super(message);
	}
}
