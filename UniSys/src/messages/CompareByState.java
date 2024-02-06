package messages;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByState implements Comparator<Order>, Serializable{

	@Override
	/**
	 * 
	 * @return the method which compare two objects of Order class by their states
	 */
	public int compare(Order o1, Order o2) {
		return o1.compareTo(o2);
	}

}
