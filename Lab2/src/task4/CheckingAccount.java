package task4;

public class CheckingAccount extends Account{
	private int countOfTransactions;
	private int freeTransactions;
	private final double FEE = 0.02;
	{
		countOfTransactions = 0;
		freeTransactions = 3;
	}
	public CheckingAccount() {

	}
	public CheckingAccount(int id) {
		super(id);
	}
	public CheckingAccount(int id, double b) {
		super(id, b);
	}

	public void deductFee() {
		if(freeTransactions > 0) {
			freeTransactions-=1;
		}
		else {
			super.withdraw(FEE);
		}
	}
	public void deposit (double sum) {
		super.deposit(sum);
		countOfTransactions++;
		deductFee();
	}
	public int getCountOfTransactions() {
		return countOfTransactions;
	}
	public int getFreeTransactions() {
		return freeTransactions;
	}
	public double getFee() {
		return FEE;
	}
	public void resetFreeTransactions() {
		freeTransactions = 3;
	}
	public void withdraw (double sum) {
		super.withdraw(sum);
		countOfTransactions++;
		deductFee();
	}
	public void transfer(double amount, Account other) {
		super.withdraw(amount);
		other.deposit(amount);
		countOfTransactions++;
	}
	public String toString() {
		return "Checking " + super.toString() + " ,fee is: " + getFee() + 
				"\nOverall transactions: " + getCountOfTransactions() +
				" and there are: " + getFreeTransactions() + " free transactions left" ;
	}


}
