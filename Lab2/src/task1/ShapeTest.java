package task1;
import java.util.Vector;

public class ShapeTest {
	public static void main(String args[]) {
		Vector<Shape> shapes = new Vector<Shape>();
		shapes.add(new Sphere ("sphere", 6));
		shapes.add(new Cube("cube", 4));
		shapes.add(new Cylinder("cylinder", 5, 13));
		for(Shape shape : shapes) {
			System.out.println(shape);
		}
	}
}
