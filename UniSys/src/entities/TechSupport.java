package entities;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;
import java.util.Vector;
import java.util.stream.Collectors;

public class TechSupport extends Employee implements Serializable {
	private Vector<Order> techSupportOrders;;

	{
		techSupportOrders = new Vector<Order>();
	}

	public TechSupport() {}

	public TechSupport(String userId, Login login, String email, String name, String surname) {
		super(userId, login, email, name, surname);
	}

	protected String getStartMessage() {
		return super.getStartMessage()
				+ "\n10) View new orders"
				+ "\n11) View accepted orders"
				+ "\n12) View done orders"
				+ "\n13) View rejected orders"
				+ "\n14) View all orders"
				+ "\n15) Accept order"
				+ "\n16) Reject order"
				+ "\n17) Complete order";
	}

	/**
	 * 
	 * @param state  state of an order that we want to view
	 */
	private void viewOrders(State state) {
		for(Order i: techSupportOrders) {
			if (i.getState() == state) {
				System.out.println(i.toString());
			}
		}
	}
	/**
	 * view a list of all orders
	 */
	public void viewAllOrders() {
		for(Order o : techSupportOrders) {
			System.out.println(o);
		}
	}

	/**
	 * view a list of new orders
	 */
	public void viewNewOrders() {
		viewOrders(State.NEW);
	}

	/**
	 * view a list of accepted orders
	 */
	public void viewAcceptedOrders() {
		viewOrders(State.ACCEPTED);
	}

	/**
	 * view a list of done orders
	 */
	public void viewDoneOrders() {
		viewOrders(State.DONE);
	}

	/**
	 * view a list of rejected orders
	 */
	public void viewRejectedOrders() {
		viewOrders(State.REJECTED);
	}

	/**
	 * 
	 * @param o object of Order class that we want to add techSupport orders vector
	 */
	public void addOrder(Order o) {
		techSupportOrders.add(o);
	}

	/**
	 * 
	 * @param o new object of Order class for setter
	 */
	public void setOrderAsDone(Order o) {
		o.setState(State.DONE);
	}

	/**
	 * 
	 * @param  state of the order by which we want to sort vector of techSupport orders
	 * @return a vector of techSupport orders which is sorted by certain state
	 */
	public Vector<Order> filterOrderByState(State state) {
		return techSupportOrders.stream()
				.filter(order -> order.getState() == state)
				.collect(Collectors.toCollection(Vector::new));
	}

	/**
	 * 
	 * @param o new object of Order class for setter
	 */
	public void setOrderAsAccepted(Order o) {
		o.setState(State.ACCEPTED);
	}

	/**
	 * 
	 * @param o new object of Order class for setter
	 */
	public void setOrderAsRejected(Order o) {
		o.setState(State.REJECTED);
	}

	@Override
	/**
	 * 
	 * @return the method for hashing fields
	 */
	public int hashCode() {
		return Objects.hash(super.hashCode(), techSupportOrders);
	}

	@Override
	/**
	 * 
	 * @return the method for checking equality
	 */
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		TechSupport d = (TechSupport)obj;
		return d.techSupportOrders.equals(this.techSupportOrders);
	}

	@Override
	/**
	 * 
	 * @return the method returns the string of employee attributes
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * 
	 * @return all techSupport orders
	 */
	public Vector<Order> getTechSupportOrders() {
		return techSupportOrders;
	}

	/**
	 * 
	 * @param a new vector of techSupport orders for setter
	 */
	public void setTechSupportOrders(Vector<Order> techSupportOrders) {
		this.techSupportOrders = techSupportOrders;
	}

}
