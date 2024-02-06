package lab1;

public class Plant {
	private String color;
	private String name;
	private double height;
	private static double totalHeight = 0;
	private static final double MAX_HEIGHT = 5; // read only
	private static int numOfPlants = 0;
	LightRequirement type;
	{
		numOfPlants++;
	}
	public Plant() {
		
	}
	public Plant(double height) {
		this.height = height;
		totalHeight += height;
	}
	public Plant(String name) {
		this.name = name;
	}
	public Plant(String name, String color, double height) {
		this(height);
		this.name = name;
		this.color = color;
	}
	public Plant(String name, String color, double height, LightRequirement type) {
		this(name ,color, height);
		this.type = type;
	}
	
	public String toString() {
		return name + " " + color + " " + height + " " + type;
	}
	
	public void cutPlant() {
		double cut = height/4;
		this.height -= cut;
		totalHeight -= cut;
	}
	
	public void cutPlant(double amount) {
		if(amount<height) {
			height -= amount;
			totalHeight -= amount;
		}
		else {
			System.err.println("Cut is mre than the height of plant!");
			System.exit(1);
		}
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public static double getMaxHeight() {
		return MAX_HEIGHT;
	}
	public static double getAverageHeight(){
		return totalHeight / numOfPlants;
	}
	public static int getNumOfPlants() {
		return numOfPlants;
	}
}
