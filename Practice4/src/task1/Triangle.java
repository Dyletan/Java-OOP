package task1;

public class Triangle extends Shape{
	int height;
	public Triangle() {
		
	}
	public Triangle(int h) {
		height = h;
	}
	
	public String draw() {
		String res = "";
		for(int i = 0; i < height; i++) {
	        String line = "";

	        // Add leading spaces
	        for(int j = 0; j < height - i - 1; j++) {
	            line += " ";
	        }

	        // Add asterisks
	        for(int j = 0; j < 2 * i + 1; j++) {
	            line += "*";
	        }

	        res+=line+"\n";
	    }
		return res;
	}

}
