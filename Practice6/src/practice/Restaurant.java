package practice;

public class Restaurant {
	String name;
	public Restaurant(){}
	public Restaurant(String name) {
		this.name = name;
	}
	void servePizza(CanHavePizza eater){
		eater.eatPizza();
		if(eater instanceof Person2) {
			System.out.println("Now you need to pay for it >:)");
		}
	}
	
	public void servePizza(CanHavePizza eater, int amount) {
		if(eater instanceof Person2) {
			Person2 p = (Person2) eater;
			if(p.balance>=amount*Person2.PRICE) {
				System.out.println("'What a good pizza' - says " + p.getName() + " he had " + amount + " of them and payed " + amount*Person2.PRICE);
				p.balance -= amount*Person2.PRICE;
			} else {
				System.out.println("Not enough money to buy pizza");
			}
		}else{
			eater.eatPizza();
		}

	}
}

