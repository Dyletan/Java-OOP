package task3;

public class Queen extends Piece{
	public Queen() {

	}
	public Queen(Position position, Color color) {
		super(position, color);
	}

	@Override
	public boolean isLegalMove(Position a, Position b) {
		Bishop c = new Bishop();
		Rook d = new Rook();
		return c.isLegalMove(a, b) || d.isLegalMove(a, b);	
	}

}
