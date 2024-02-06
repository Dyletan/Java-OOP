package task2;

public class Player implements MoveableAndCanShoot {
	private String name;
	private int health;

	public Player(String name, int health) {
		this.name = name;
		this.health = health;
	}

	@Override
	public void move() {
		System.out.println(name + " is moving.");
	}

	@Override
	public void shoot() {
		System.out.println(name + " is shooting.");
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	public String toString() {
		return getName() + " " + getHealth();
	}
}

