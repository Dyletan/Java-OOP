package messages;


import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.Serializable;
import java.util.Objects;

public class Request extends Message implements Acceptable, Serializable {
	private int accepted;
	
	{
		accepted = 0;
	}

	public Request() {}
	
	public Request(String title, String message, Employee recipient, Employee sender, Priority priority) {
		super(title, message, recipient, sender);
	}

	/**
	 * 
	 * @param new accepted sign for setter
	 * @return 
	 */
	public void makeAccepted(int accepted) {
		this.accepted = accepted;
	}

	@Override
	/**
	 * 
	 * @return getter for accepted sign
	 */
	public int isAccepted() {
		return accepted;
	}
	
	@Override
	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(super.hashCode(), accepted);
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality
	 */
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Request d = (Request)obj;
		return d.accepted == this.accepted;
	}

	@Override
	/**
	 * 
	 * @return the method which returns message's attributes and acception sign
	 */
	public String toString() {
		return super.toString() + (isAccepted()==1 ? "Accepted" : "Rejected");
	}
}
