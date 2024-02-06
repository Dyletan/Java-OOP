package practice;

public class Test {
	public static void main(String args[]) {
		Restaurant delpapa = new Restaurant("Del papa");
		Person2 p1 = new Person2("Bob", 40000);
		Cat c1 = new Cat();
		delpapa.servePizza(p1, 300);
		delpapa.servePizza(c1);
	}
}
