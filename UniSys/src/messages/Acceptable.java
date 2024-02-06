package messages;

import java.io.Serializable;

public interface Acceptable  extends Serializable {
	/**
	 * 
	 * @param to set new acception sign
	 */
	void makeAccepted(int accepted);
	/**
	 * 
	 * @return the method which returns sign of acception
	 */
	int isAccepted();
}
