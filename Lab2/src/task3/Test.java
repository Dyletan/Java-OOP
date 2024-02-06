package task3;

import java.util.Vector;

public class Test {
	public static void main(String args[]) {
		Position p1 = new Position('E', 4);
		System.out.println(p1);
		Pawn whitePawn = new Pawn(new Position('E', 1), Color.WHITE);
		whitePawn.move(p1);
		whitePawn.move(new Position('E', 5));
		Pawn blackPawn = new Pawn(new Position('E', 5), Color.BLACK);
		blackPawn.move(new Position('E', 4));
		Rook rook = new Rook(new Position('F', 7), Color.WHITE);
		rook.move(new Position('F', 3));
		King king = new King(new Position('C', 8), Color.BLACK);
		king.move(new Position('B', 7));
		Queen queen = new Queen(new Position('H', 5), Color.WHITE);
		Bishop bishop = new Bishop(new Position('A', 6), Color.BLACK);
		Knight kngiht = new Knight(new Position('G', 2), Color.BLACK);
		Vector<Piece> p = new Vector<Piece>();
		p.add(whitePawn);
		p.add(blackPawn);
		p.add(rook);
		p.add(king);
		p.add(queen);
		p.add(bishop);
		p.add(kngiht);
		for(Piece i : p) {
			System.out.println(i);
		}
	}
}
