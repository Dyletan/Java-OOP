package task3;

public class Rook extends Piece{
	public Rook() {

	}
	public Rook(Position position, Color color) {
		super(position, color);
	}

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if(boardConstraint(b)) return false;
		if(a.equals(b)) return false;
		if((b.getVertical() == a.getVertical()) || (b.getHorizontal() == a.getHorizontal())) {
			return true;
		}
		return false;
	}
}
