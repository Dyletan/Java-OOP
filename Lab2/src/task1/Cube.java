package task1;

public class Cube extends Shape{
	private double length;
	{
		length = 0;
	}
	public Cube() {

	}
	public Cube(String name) {
		super(name);
	}
	public Cube(String name, int l) {
		this(name);
		length = l;
	}
	
	public double volume() {
		return length * length * length;
	}
	public double surfaceArea() {
		return 6 * length*length;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double l) {
		length = l;
	}
}
