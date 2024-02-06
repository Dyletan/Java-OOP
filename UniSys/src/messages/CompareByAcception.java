package messages;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByAcception implements Comparator<Acceptable>, Serializable{

	@Override
	/**
	 * 
	 * @return the method which compare two objects of Acceptable class by their acceptions
	 */
	public int compare(Acceptable o1, Acceptable o2) {
		return Integer.compare(o1.isAccepted(), o2.isAccepted());
	}

}
