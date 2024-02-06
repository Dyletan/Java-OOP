package task2;

public class Grenade implements Moveable{
	private final double INITIAL_SPEED = 15;
	private final double ACCELERATION = -3;
	public Grenade() {};
	
	@Override
	public void move() {
		System.out.println("The granade has moved: " + (-INITIAL_SPEED*INITIAL_SPEED/(2*ACCELERATION)));
	}
	
}
