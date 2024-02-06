package task4;

public class Account {
	private double balance; //The current balance
	private int accNumber; //The account number
	public Account() {
		balance = 0.0;
	}
	public Account (int id) {
		this();
		accNumber=id;
	}
	public Account (int id, double b) {
		this(id);
		balance=b;
	}

	public void deposit (double sum) {
		balance += sum;
	}
	public void withdraw (double sum) {
		if(sum > getBalance()) {
			System.err.println("Unable to withdraw money from account: " + getAccountNumber());
		}
		else{
			balance -= sum;
		}
	}
	public double getBalance() {
		return balance;
	}
	public int getAccountNumber() {
		return accNumber;
	}
	public void transfer (double amount, Account other) {
		withdraw(amount);
		other.deposit(amount);
	}
	public String toString() {
		return "Account " + getAccountNumber() + " has " + getBalance() + " dollars";
	}
	public final void print() {
		System.out.println(toString());
	}
}
