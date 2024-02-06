package task4;
import java.util.Scanner;
import java.util.Vector;

public class Bank {
	private Vector<Account> accounts;
	{
		accounts = new Vector<Account>();
	}
	public Bank() {}
	
	private void makeChange(Account i) {
		if(i instanceof SavingsAccount) {
			((SavingsAccount) i).addInterest();
		} else if(i instanceof CheckingAccount) {
			((CheckingAccount)i).deductFee();
		}
	}
	
	public void update() {
		System.out.println("To deposit a sum input D, to withdraw input W");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("D")) {
			System.out.println("Input the aforementioned sum");
			double sum = in.nextInt();
			for(Account i : accounts) {
				i.deposit(sum);
				makeChange(i);
			}
		}
		else if(input.equals("W")) {
			System.out.println("Input the aforementioned sum");
			double sum = in.nextInt();
			for(Account i : accounts) {
				i.withdraw(sum);
				makeChange(i);
			}
		} else {
			System.err.println("Invalid input");
		}
		in.close();
	}
	
	public void addAccount(Account a) {
		accounts.add(a);
	}
	public void closeAccount(Account a) {
		accounts.remove(a);
	}
	public String toString() {
		String res = "There are these bank accounts:\n";
		for(Account i : accounts) {
			res += i.toString() + "\n";
		}
		return res;
	}
}
