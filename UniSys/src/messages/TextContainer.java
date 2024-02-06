package messages;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class TextContainer implements Serializable {
	private String title;
	private String message;
	private LocalDateTime time;
	{
		time = LocalDateTime.now();
	}

	public TextContainer() {
	}
	
	public TextContainer(String title, String message) {
		this.title = title;
		this.message = message;
	}

	/**
	 * 
	 * @return getter for title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param new title for setter
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return getter for message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param new message for setter
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return getter for time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	@Override
	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(message, time, title);
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextContainer other = (TextContainer) obj;
		return Objects.equals(message, other.message) && Objects.equals(time, other.time)
				&& Objects.equals(title, other.title);
	}

	@Override
	/**
	 * 
	 * @return the method which return string includes title, time and message
	 */
	public String toString() {
		return "Title: " + getTitle() + "\nTime: " + getTime() + "\nMessage: " + getMessage();
	}

}
