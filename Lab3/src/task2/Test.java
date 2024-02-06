package task2;

public class Test {
	public static void main(String args[]) {
		Grenade g = new Grenade();
		Helicopter h = new Helicopter("Mig-2", 2000);
		Player p = new Player("Nagibator", 100);
		g.move();
		h.move();
		h.shoot();
		p.move();
		p.shoot();
	}
	
	
}
