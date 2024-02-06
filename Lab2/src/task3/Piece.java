package task3;

public abstract class Piece {
	private Position position;
	private Color color;
	
	public Piece() {
		
	}
	public Piece(Position position, Color color) {
		this.position = position;
		this.color = color;
	}
	
	public abstract boolean isLegalMove(Position a, Position b);
	
	public void move(Position b) {
		if(isLegalMove(position, b)) {
			position = b;
			System.out.println("Lets goo, a legal move");
		}
		else {
			System.err.println("This is an illegal move");
		}
		
	}

	public boolean boardConstraint(Position a) {
		if(a.getHorizontal() > 8 || a.getVertical() > 8) {
			return false;
		}
		return true;
	}
	public Color getColor() {
		return color;
	}
	public Position getPosition() {
		return position;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String toString() {
		return "This is a " + getColor() + " " + this.getClass().getSimpleName() + " with position " + getPosition().toString();
	}
}
