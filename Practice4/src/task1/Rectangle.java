package task1;

public class Rectangle extends Shape{
	private int width;
	private int length;
	public Rectangle() {
		
	}
	public Rectangle(int w, int l) {
		width = w;
		length = l;
	}
	public String draw() {
		String result = "";
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				if( i == 0 || i == length-1) {
					result += "-";
				} else {
					if(j == 0 || j == width-1)
						result += '|';
					else
						result += " ";
				}
			}
			result+="\n";
		}
		return result;
	}

}
