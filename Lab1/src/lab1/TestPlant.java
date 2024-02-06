package lab1;

public class TestPlant {
	public static void main(String[] args) {
		Plant rose = new Plant("Rose", "Red", 3, LightRequirement.HALF_SHADE);
		System.out.println(rose);
		rose.cutPlant();
		System.out.println(rose);
		Plant dandeline = new Plant("Dandeline", "White", 0.3, LightRequirement.IN_SUN);
		System.out.println(Plant.getNumOfPlants()); 
		System.out.println(Plant.getAverageHeight());
		System.out.println(dandeline);
	}
}
