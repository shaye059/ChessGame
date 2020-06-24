/**
 * 
 */
package model;

import org.javatuples.Pair;

/**
 * @author spenc
 *
 */
public class Piece {
	//Attributes
	private Pair<Integer,Integer>[] possible_moves;
	private boolean was_moved;
	private String colour;
	private String piece_name;
	
	//Constructor
	public Piece(String colour) {
		this.colour = colour;
		was_moved = false;
	}
	
	//Methods
	public Pair<Integer,Integer>[] getPossibleMoves(Board current_board){
		if(was_moved == true) {
			getNewMoves();
			was_moved = false;
		}
		return possible_moves;
	}
	
	public void getNewMoves() {
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public String getPieceName() {
		return piece_name;
	}
	
	public void setPieceName(String name) {
		this.piece_name = name;
	}
	
}



