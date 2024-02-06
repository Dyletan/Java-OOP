package messages;

import java.io.Serializable;
import java.util.Objects;
import messages.*;
import entities.*;
import containers.*;
import data.*;

public class Complaint extends Message implements Acceptable, Comparable<Complaint>, Serializable {
	private Priority priority;
	private int accepted;
	
	{
		accepted = 0;
	}
	
	public Complaint() {
	}
	
	public Complaint(String title, String message, Employee recipient, Employee sender, Priority priority) {
		super(title, message, recipient, sender);
		this.priority = priority;
	}

	/**
	 * 
	 * @return getter for priority
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param new priority for setter
	 */
	/**
	 * 
	 * @param new priority for setter
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	/**
	 * 
	 * @return the method returns sign of acception
	 */
	public int isAccepted() {
		return accepted;
	}


	/**
	 * 
	 * @param Complaint object which we want to compare
	 * @return the method returns result of comparing priorities of complaints
	 */
	public int compareTo(Complaint o) {
		return priority.compareTo(o.priority);
	}

	/**
	 * 
	 * @param new accepted sign for setter
	 */
	public void makeAccepted(int accepted) {
		this.accepted = accepted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Complaint complaint = (Complaint) o;
		return accepted == complaint.accepted && priority == complaint.priority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), priority, accepted);
	}

	/**
	 * @return the method returns message's attributes, priority of complaint and sign of acception
	 */
	@Override
	public String toString() {
	    String acceptedStatus;
	    
	    switch (accepted) {
	        case 1:
	            acceptedStatus = "Accepted";
	            break;
	        case 0:
	            acceptedStatus = "Not yet Viewed";
	            break;
	        case -1:
	            acceptedStatus = "Rejected";
	            break;
	        default:
	            acceptedStatus = "No info";
	    }

	    return "Complaint{" +
	            "priority=" + priority +
	            ", accepted=" + acceptedStatus +
	            '}';
	}
}
