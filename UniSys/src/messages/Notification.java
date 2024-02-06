package messages;

import java.io.Serializable;
import java.util.Objects;

public class Notification extends TextContainer implements Serializable {

	public Notification() {}
	
	public Notification(String title, String message) {
		super(title, message);
	}
	
	@Override
	/**
	 * 
	 * @return the method for hashing notifications
	 */
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality
	 */
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	/**
	 * 
	 * @return the method which returns textcontainer's attributes
	 */
	public String toString() {
		return super.toString();
	}

}
