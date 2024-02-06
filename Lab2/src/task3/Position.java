package task3;

public class Position {
	private int horizontal;
	private int vertical;
	public Position() {
		
	}
	public Position(char horizontal, int vertical) {
		int p = Math.abs(horizontal);
		this.horizontal = horizontal-64;
		this.vertical = vertical;
	}
	public char getHorizontal() {
		return (char)(horizontal+64);
	}
	public int getVertical() {
		return vertical;
	}
	
	public String toString() {
	    return getHorizontal() + Integer.toString(getVertical());
	}
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) return false;
		Position p = (Position) o;
		if(p.horizontal == this.horizontal && p.vertical == this.vertical) {
			return true;
		}
		return false;
	}
}
