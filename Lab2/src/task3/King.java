package task3;

public class King extends Piece{
	public King() {

	}
	public King(Position position, Color color) {
		super(position, color);
	}

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if(boardConstraint(b)) return false;
		if(a.equals(b)) return false;
		if((b.getHorizontal() == a.getHorizontal() - 1 ||
				b.getHorizontal() == a.getHorizontal() +1 ||
				b.getHorizontal() == a.getHorizontal()) 
				&& (b.getVertical() == a.getVertical() - 1 ||
				b.getVertical() == a.getVertical() +1 ||
				b.getVertical() == a.getVertical())) {
			return true;
		}
		return false;
	}

}
