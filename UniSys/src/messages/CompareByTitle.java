package messages;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByTitle implements Comparator<Message>, Serializable{

	@Override
	/**
	 * 
	 * @return the method to compare two objects of Message class by their titles
	 */
	public int compare(Message o1, Message o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
