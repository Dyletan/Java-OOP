package messages;

import java.io.Serializable;
import java.util.Comparator;

class CompareByDate implements Comparator<Message>, Serializable{

	@Override
	/**
	 * 
	 * @return the method which compare two objects of Message class by their date
	 */
	public int compare(Message o1, Message o2) {
		return o1.getTime().compareTo(o2.getTime());
	}
	
}
