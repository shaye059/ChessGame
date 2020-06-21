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
	private String colour;
	private Pair<Integer, Integer> space; //May remove this later. Depending on board setup it may be redundant.
	private Piece occupying_piece;
	
	public Square(String colour, Pair<Integer, Integer> space, Piece occupying_piece) {
		this.colour = colour;
		this.space = space;
		this.occupying_piece = occupying_piece;
	}
	
	@Override
	public String toString() {
		return('(' + colour + ',' + '[' + space.getValue0() + ',' + space.getValue1() + "])");
	}
}
