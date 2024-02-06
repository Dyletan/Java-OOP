package task3;

public class Pawn extends Piece{
	boolean isFirstMove;
	{
		isFirstMove = false;
	}
	public Pawn() {
		
	}
	public Pawn(Position position, Color color) {
		super(position, color);
	}
	
	public void move(Position b) {
		super.move(b);
	}
	
	
	@Override
	public boolean isLegalMove(Position a, Position b) {
		if(boardConstraint(b)) return false;
		if(getColor() == Color.BLACK) {
			if(!isFirstMove) {
				isFirstMove = true;
				if(b.getVertical() == a.getVertical() - 1 || b.getVertical() == a.getVertical()-2) {
					return true;
				}
				else {
					return false;
				}
			}
			if(b.getVertical() == a.getVertical() - 1) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(!isFirstMove) {
				isFirstMove = true;
				if(b.getVertical() == a.getVertical() + 1 || b.getVertical() == a.getVertical()+2) {
					return true;
				}
				else {
					return false;
				}
			}
			if(b.getVertical() == a.getVertical() + 1) {
				return true;
			}
			else {
				return false;
			}
		}
	}

}
