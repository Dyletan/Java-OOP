package practice;
import task1.Animal;

public class Cat extends Animal implements CanHavePizza{

	@Override
	public String speak() {
		return "meow";
	}

	@Override
	public String eat() {
		return "Cat is eating";
	}

	@Override
	public void eatPizza() {
		System.out.println("Meow, what a good pizza ^-^");		
	}

}
