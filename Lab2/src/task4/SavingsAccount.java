package task4;

public class SavingsAccount extends Account{
	private double interestRate;
	{
		interestRate = 0.05;
	}
	
	public SavingsAccount() {}
	public SavingsAccount(int id) {
		super(id);
	
	}
	public SavingsAccount(int id, double b) {
		super(id,b);
		
	}
	
	public void addInterest() {
		deposit(getBalance()*interestRate);
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double i) {
		interestRate = i;
	}
	public String toString() {
		return "Savings " + super.toString() + " with interest rate: " + getInterestRate()*100 + "%";
	}
}
