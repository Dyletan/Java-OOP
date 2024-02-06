package messages;


public enum State implements Comparable<State>{
	/**
	 * a new order that has just arrived
	 */
	NEW, 
	/**
	 * order in the process
	 */
	ACCEPTED, 
	/**
	 * incorrect or impossible order which rejected
	 */
	REJECTED, 
	/**
	 * order which is finished
	 */
	DONE;
}
