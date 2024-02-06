package task4;

public class Test {
	public static void main(String[] args) {
		Account a1 = new Account(1);
		CheckingAccount a2 = new CheckingAccount(2, 4000);
		a2.withdraw(500);
		a2.deposit(2);
		SavingsAccount a3 = new SavingsAccount(3, 600);
		Bank central = new Bank();
		central.addAccount(a1);
		central.addAccount(a2);
		central.addAccount(a3);
		System.out.println("Initital balance:");
		System.out.println(central);
		central.update();
//		a2.transfer(100, a3);
		System.out.println(central);
		central.closeAccount(a1);
		a2.resetFreeTransactions();
		System.out.println(central);
	}
	
}
