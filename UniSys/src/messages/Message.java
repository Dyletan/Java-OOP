package messages;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.Serializable;
import java.util.Objects;

public class Message extends TextContainer implements Serializable {
	private Employee recipient;
	private Employee sender;

	public Message() {}
	
	public Message(String title, String message, Employee recipient, Employee sender) {
		super(title, message);
		this.recipient = recipient;
		this.sender = sender;
	}

	/**
	 * 
	 * @return getter for recipient
	 */
	public Employee getRecipient() {
		return recipient;
	}

	/**
	 * 
	 * @param recipient new recipient for setter
	 */
	public void setRecipient(Employee recipient) {
		this.recipient = recipient;
	}

	/**
	 * 
	 * @return getter for sender
	 */
	public Employee getSender() {
		return sender;
	}

	/**
	 * 
	 * @param sender new sender for setter
	 */
	public void setSender(Employee sender) {
		this.sender = sender;
	}

	@Override
	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(super.hashCode(), recipient, sender);
	}

	@Override
	/**
	 * 
	 * @return the method of checking equality
	 */
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Message d = (Message)obj;
		return d.recipient.equals(this.recipient) && d.sender.equals(this.sender);
	}

	@Override
	/**
	 * 
	 * @return the method which returns string includes recipient, sender and all message attributes
	 */
	public String toString() {
		return "Recipient: " + getRecipient() + "\nSender=" + getSender() + "\n" + super.toString();
	}
	

}
