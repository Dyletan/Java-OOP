package messages;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

public class Inbox  implements Serializable {
	private Vector<Message> receivedMessages;
	private Vector<Message> sentMessages;

	{
		receivedMessages = new Vector<Message>();
		sentMessages = new Vector<Message>();
	}

	public Inbox() {}

	/**
	 * 
	 * @param c It is the comparator which is used to sort received messages
	 * @return Returns the result as string of sorted received messages
	 */
	public String viewReceivedMessages(Comparator<Message> c) {
		receivedMessages.sort(c);
		String result = "Received messages: ";
		for (Message m: receivedMessages) {
			result += "\n" + m;
		}
		return result;
	}

	/**
	 * 
	 * @return The method to view received messages which is sorted by date
	 */
	public String viewReceivedMessages() {
		return viewReceivedMessages(new CompareByDate());
	}


	/**
	 * 
	 * @param c It is the comparator which is used to sort sent messages
	 * @return Returns the result as string of sorted sent messages
	 */
	public String viewSentMessages(Comparator<Message> c) {
		sentMessages.sort(c);
		String result = "Sent messages: ";
		for (Message m: sentMessages) {
			result += "\n" + m;
		}
		return result;
	}

	/**
	 * 
	 * @return The method to view sent messages which is sorted by date
	 */
	public String viewSentMessages() {
		return viewSentMessages(new CompareByDate());
	}


	@Override
	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(receivedMessages, sentMessages);
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inbox other = (Inbox) obj;
		return Objects.equals(receivedMessages, other.receivedMessages)
				&& Objects.equals(sentMessages, other.sentMessages);
	}

	/**
	 * 
	 * @return the method which show all messages
	 */
	public String toString() {
		return viewReceivedMessages() + "\n" + viewSentMessages();
	}

	/**
	 * 
	 * @return the method to get received messages without sorting
	 */
	public Vector<Message> getReceivedMessages() {
		return receivedMessages;
	}

	/**
	 * 
	 * @return the method to get sent messages without sorting
	 */
	public Vector<Message> getSentMessages() {
		return sentMessages;
	}

	/**
	 * 
	 * @param new vector of received messages for setter
	 */
	public void setReceivedMessages(Vector<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
	/**
	 * 
	 * @param new vector of sent messages for setter
	 */
	public void setSentMessages(Vector<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

}
