package task1;

public class Sphere extends Shape{
	private double radius;
	{
		radius = 0;
	}
	public Sphere(){

	}
	public Sphere(String name){
		super(name);
	}
	public Sphere(String name, double radius){
		super(name);
		this.radius = radius;
	}
	@Override
	public double volume() {
		return 4/3 * Math.PI * radius*radius*radius;
	}

	@Override
	public double surfaceArea() {
		return 4 * Math.PI * radius*radius;
	}
	public String toString() {
		return super.toString();
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
