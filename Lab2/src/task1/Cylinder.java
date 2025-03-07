package task1;
import java.lang.Math;

public class Cylinder extends Shape{
	private double radius;
	private double height;
	{
		radius = 0;
		height = 0;
	}
	public Cylinder(){
		
	}
	public Cylinder(String name) {
		super(name);
	}
	public Cylinder(String name, double radius, double height) {
		super(name);
		this.radius = radius;
		this.height = height;
	}
	@Override
	public double volume() {
		return Math.PI * radius * radius * height;
	}

	@Override
	public double surfaceArea() {
		return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
	}
	public String toString() {
		return super.toString() + " with radius " + getRadius() + " and height " + getHeight();
	}
	public double getRadius() {
		return radius;
	}
	public double getHeight() {
		return height;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
