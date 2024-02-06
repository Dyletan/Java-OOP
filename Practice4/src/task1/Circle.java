package task1;

public class Circle extends Shape{

	public Circle() {
		
	}
	public Circle(String name, int r) {
		super(name);
	}
	public String draw() {
		return "O";		
	}
	public String draw(int num) {
		String result = "";
		for(int i = 0; i < num; i++) {
			result+="O";
		}
		return result;		
	}
	
	public String toString() {
		return super.toString();
	}

}
