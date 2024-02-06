package task3;

public class Knight extends Piece{
	public Knight() {

	}
	public Knight(Position position, Color color) {
		super(position, color);
	}

	@Override
	public boolean isLegalMove(Position a, Position b) {
		int dx = Math.abs(a.getHorizontal() - b.getHorizontal());
		int dy = Math.abs(a.getVertical() - b.getVertical());

		if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
			return true;
		}
		return false;
	}

}
