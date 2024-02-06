package task1;
import java.util.Vector;

public class Parrot extends Animal{
	Vector<String> phrases;
	{
		phrases = new Vector<String>();
	}
	public Parrot(){
		
	}
	public Parrot(String name, String color, TypeOfAnimal type){
		super(name, color, type);
	}
	public void addPhrase(String phrase) {
		phrases.add(phrase);
	}
	public String toString() {
		String result = super.toString();
		String learned = "";
		for(String phrase : phrases) {
			learned += "\n" + phrase; 
		}
		return result + "and he learned this phrases:" + learned;
	}
	public String speak() {
		return "Hello, human";
	}
	public String eat() {
		return "Parrot is eating from kormushka";
	}
	public String eat(String food) {
		return getName() + " is eating " + food;
	}
}
