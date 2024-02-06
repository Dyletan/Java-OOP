package lab1;

public class TestTemperature {
	public static void main(String[] args) {
		Temperature t1 = new Temperature(5, 'F');
		Temperature t2 = new Temperature(23, 'C');
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1.getScale());
		System.out.println(t2.getDegreeCelcius());
		System.out.println(t2.getDegreeFarenheit());
		t1.setTemperature(44.3, 'F');
		System.out.println(t1.getDegreeCelcius());
	}
}
