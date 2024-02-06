package task1;

public abstract class Shape {
	private String name;
	public Shape(){
		
	}
	public Shape(String name) {
		this.name = name;
	}
	public abstract String draw();
	public String getName() {
		return name;
	};
	public void setName(String name) {
		this.name = name;
	};
	public String toString() {;
		return getName();
	}
}
