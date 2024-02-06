package practice;
import task2.Person;

public class Person2 extends Person implements CanHavePizza{
	public double balance;
	public final static double PRICE = 2000;
	
	public Person2() {
		super();
	}
	public Person2(String name) {
		super(name);
	}
	public Person2(String name, double b) {
		super(name);
		balance = b;
	}

	@Override
	public void eatPizza() {
		System.out.println("'What a good pizza' - says " + getName());
	}
	

}
