/**
 * 
 */
package model;

import org.javatuples.Pair;

/**
 * @author spenc
 *
 */
public class Square {
	//Attributes
	private final String colour;
	private Pair<Integer, Integer> space; //May remove this later. Depending on board setup it may be redundant.
	private Piece occupying_piece;
	private boolean is_occupied;
	
	//Constructor
	public Square(String colour, Pair<Integer, Integer> space, Piece occupying_piece) {
		this.colour = colour;
		this.space = space;
		this.occupying_piece = occupying_piece;
		if(occupying_piece != null) {
			this.is_occupied = true;
		}
		else {
			this.is_occupied = false;
		}
	}
	
	//Methods
	@Override
	public String toString() {
		return('(' + colour + ',' + '[' + space.getValue0() + ',' + space.getValue1() + "])");
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public Piece getOccupyingPiece() {
		return this.occupying_piece;
	}
	
	public String getOccupyingPieceColour() {
		return this.occupying_piece.getColour();
	}
	
	public void setPiece(Piece new_occupying_piece) throws SpaceOccupiedException {
		if (this.occupying_piece != null) {
			throw new SpaceOccupiedException(this.space);
		}
		else {
			this.occupying_piece = new_occupying_piece;
		}
	}
	
	public void removeOccupyingPiece() {
		this.occupying_piece = null;
		this.is_occupied = false;
	}
	
	public boolean isOccupied() {
		return is_occupied;
	}
}

class SpaceOccupiedException extends Exception {
	   /**
	 * Thrown when a piece tries to occupy a space that is already taken.
	 */
	private static final long serialVersionUID = 1L;
	Pair space;

	   public SpaceOccupiedException(Pair<Integer, Integer> space) {
	      this.space = space;
	   }

	   public String toString() {
	      return "SpaceOccupiedException for space [" + space + "]";
	   }
	}
