package task1;

public class ParrotTest {

	public static void main(String[] args) {
		Parrot gumba = new Parrot("Gumba", "green", TypeOfAnimal.DOMESTICATED);
		System.out.println(gumba.speak());	
		gumba.addPhrase("How are you?");
		gumba.addPhrase("Show must go on");
		gumba.addPhrase("Honk");
		System.out.println(gumba.toString());
		System.out.println(gumba.eat("seed"));
	}

}
