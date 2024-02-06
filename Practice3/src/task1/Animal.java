package task1;

public abstract class Animal {
	protected String name;
	protected String color;
	TypeOfAnimal type;
	
	public Animal(){
		
	}
	public Animal(String name, String color){
		this.name = name;
		this.color = color;
	}
	public Animal(String name, String color, TypeOfAnimal type){
		this(name, color);
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract String speak();
	public abstract String eat();
	public String toString() {
		return "this is " + getName() + " " + speak() + ", of " + getColor() + "color";
	}
}
