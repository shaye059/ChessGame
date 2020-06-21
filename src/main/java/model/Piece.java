/**
 * 
 */
package model;

import java.util.*;  
import org.javatuples.Pair;

/**
 * @author spenc
 *
 */
class Piece {
	/**
	 * @author spenc
	 *
	 */

	//Attributes
	private Pair<Integer,Integer> position;
	private Pair<Integer,Integer>[] possible_moves;
	private boolean was_moved;
	private String colour;
	
	//Constructor
	public Piece(Pair<Integer,Integer> initial_position, String colour) {
		this.position = initial_position;
		this.colour = colour;
		was_moved = false;
	}
	
	//Methods
	public void setPosition(Pair<Integer,Integer> new_position) {
		this.position = new_position;
		was_moved = true;
	}
	
	public Pair<Integer, Integer> getPosition(){
		return this.position;
	}
	
	public Pair<Integer,Integer>[] getPossibleMoves(Board current_board){
		if(was_moved == true) {
			getNewMoves();
			was_moved = false;
		}
		return possible_moves;
	}
	
	private void getNewMoves() {
	}
}



