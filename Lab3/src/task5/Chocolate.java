package task5;

public class Chocolate implements Comparable<Chocolate>{
	private double weight;
	private String name;
	
	public Chocolate() {}
	
	public Chocolate(double weight) {
		this.weight = weight;
		name = "No name";
	}
	
	public Chocolate(double weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	@Override
	public int compareTo(Chocolate o) {
		if(weight > o.getWeight()) {
			return 1;
		}
		if(weight < o.getWeight()) {
			return -1;
		}
		return 0;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return getName() + " " + getWeight();
	}
}
