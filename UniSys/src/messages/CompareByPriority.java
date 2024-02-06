package messages;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByPriority implements Serializable, Comparator<Complaint>{

	@Override
	/**
	 * 
	 * @return the method which compare two objects of Complaint class by their priorities
	 */
	public int compare(Complaint o1, Complaint o2) {
		return o1.compareTo(o2);
	}
	
}
