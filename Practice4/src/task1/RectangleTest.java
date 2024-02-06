package task1;

import java.util.Vector;

public class RectangleTest {

	public static void main(String[] args) {
		Vector<Shape> shapes = new Vector<Shape>();
		shapes.add(new Rectangle(7, 5));
		shapes.add(new Circle());
		shapes.add(new Triangle(5));
		for(Shape i : shapes) {
			
			System.out.println(i.draw());
		}

	}

}

