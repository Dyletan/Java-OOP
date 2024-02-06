package messages;

import java.io.Serializable;
import java.util.Objects;

import entities.Employee;
import entities.TechSupport;

public class Order extends Message implements Comparable<Order>, Serializable {
	private State state;
	
	{
		state = State.NEW;
	}

	public Order() {
	}
	
	public Order(String title, String message, TechSupport techSupport, Employee employee) {
		super(title, message, techSupport, employee);
	}

	/**
	 * 
	 * @return the method which returns state
	 */
	public State getState() {
		return state;
	}

	/**
	 * 
	 * @param new state for setter
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(super.hashCode(), state);
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality
	 */
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		if(!super.equals(obj)) return false;
		Order other = (Order) obj;
		return this.state == other.state;
	}

	/**
	 * 
	 * @return the method which returns message's attributes and state of order
	 */
	public String toString() {
		return super.toString() + "State of order: " + getState();
	}

	/**
	 * 
	 * @param Order object that we want to compare
	 * @return the method returns result of comparing states of orders
	 */
	public int compareTo(Order o) {
		return state.compareTo(o.state);
	}

}
