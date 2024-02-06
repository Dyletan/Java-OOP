package entities;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public abstract class Employee extends User{
	private static final long serialVersionUID = 3530250730864962292L; // Use the value from the exception
    private Inbox inbox;
    {
    	inbox = new Inbox();
    }

    public Employee() {

    }

    public Employee(String userId, Login login, String email, String name, String surname) {
        super(userId, login, email, name, surname);
    }

    public Inbox getInbox() {
        return inbox;
    }

    public void viewInbox() {
    	for(Message m : inbox.getReceivedMessages()) {
    		System.out.println(m);
    	}
    }
    
    protected String getStartMessage() {
    	return super.getStartMessage() 
    			+ "\n6) View inbox"
    			+ "\n7) Send message to another employee"
    			+ "\n8) Send request to dean"
    			+ "\n9) Send order to tech supporter";
    }
    
    
    public void sendMessage(Message m, Employee e) throws IOException {
    	e.getInbox().getReceivedMessages().add(m);
    	this.getInbox().getSentMessages().add(m);
    }

    
    public void sendRequest(Request r, Dean d) throws IOException {
            d.getRequests().add(r);
    }
    

    
    public void sendOrder(Order o, TechSupport t) throws IOException {
    	t.addOrder(o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(inbox);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(inbox, other.inbox);
    }

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

