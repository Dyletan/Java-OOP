package task2;

public class Helicopter implements MoveableAndCanShoot {
	private String model;
	private int ammo;

	public Helicopter(String model, int ammo) {
		this.model = model;
		this.ammo = ammo;
	}

	@Override
	public void move() {
		System.out.println(model + " helicopter is moving.");
	}

	@Override
	public void shoot() {
		System.out.println(model + " helicopter is shooting.");
		ammo--;
	}

	public String getModel() {
		return model;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	public String toString() {
		return getModel() + " " + getAmmo();
	}
}

