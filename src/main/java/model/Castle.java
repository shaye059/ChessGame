package model;

public class Castle extends Piece {
	
	private boolean has_moved; //used for castling
	
	public Castle(String colour) {
		super(colour);
		has_moved = false;
		super.setPieceName("Castle");
	}
	
	public void getNewMoves() {
		
	}
}
