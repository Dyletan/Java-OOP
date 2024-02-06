package task3;

public class Bishop extends Piece{
	public Bishop() {

	}
	public Bishop(Position position, Color color) {
		super(position, color);
	}

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if(boardConstraint(b)) return false;
		if(a.equals(b)) return false;
		if(Math.abs(b.getHorizontal() - a.getHorizontal()) == Math.abs(b.getVertical() - a.getVertical())){
			return true;
		}
		return false;
	}


}
