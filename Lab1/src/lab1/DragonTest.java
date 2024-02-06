package lab1;

public class DragonTest {

	public static void main(String[] args) {
		DragonLunch dragon = new DragonLunch();
		Person p1 = new Person("Eldar", Gender.MALE); // B
		Person p2 = new Person("Amina", Gender.FEMALE); // G
		Person p3 = new Person("Damir", Gender.MALE); // B
		Person p4 = new Person("Anuar", Gender.MALE); // B
		Person p5 = new Person("Kamila", Gender.FEMALE); // G
		Person p6 = new Person("Magzhan", Gender.MALE); // B
		Person p7 = new Person("Isatai", Gender.MALE); // B
		Person p8 = new Person("Gaziza", Gender.FEMALE); // G
		Person p9 = new Person("Katya", Gender.FEMALE); // G
		Person p10 = new Person("Aisha", Gender.FEMALE); // G
		Person p11 = new Person("Isatai", Gender.MALE); // B
		Person p12 = new Person("Gaziza", Gender.FEMALE); //G
		// BG B BG B BG GG BG
		dragon.kidnap(p1);
		dragon.kidnap(p2);
		dragon.kidnap(p3);
		dragon.kidnap(p4);
		dragon.kidnap(p5);
		dragon.kidnap(p6);
		dragon.kidnap(p7);
		dragon.kidnap(p8);
		dragon.kidnap(p9);
		dragon.kidnap(p10);
		dragon.kidnap(p11);
		dragon.kidnap(p12);
		if(dragon.willDragonEatOrNot()) {
			System.out.println("The dragon will eat T_T");
		}else {
			System.out.println("Yay, everybody escaped OwO");
		}
		
	}
	
}
