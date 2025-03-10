package task1;

public abstract class Shape {
	protected String name;
	public Shape() {};
	public Shape(String name){
		this.name = name;
	}
	public abstract double volume();
	public abstract double surfaceArea();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "This is a " + getName() + " with area " + surfaceArea() + " and volume " + volume();
	};
}
