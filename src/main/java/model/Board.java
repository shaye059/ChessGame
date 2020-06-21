/**
 * 
 */
package model;

import java.util.Arrays;

import org.javatuples.Pair;

/**
 * @author spenc
 *
 */
public class Board {
	private Square[][] board;
	
	public Board() {
		
		this.board = new Square[8][8];
		String temp_colour;
		for(int row = 0; row <= 7; row++) {
			for(int column = 0; column<= 7; column++) {
				if ((row+column)%2 == 0) {
					temp_colour = "white";
				}else {
					temp_colour = "black";
				}
				Pair<Integer,Integer> space = new Pair<Integer,Integer>(row,column);
				board[row][column] = new Square(temp_colour, space, null);
			}
		}
	}
	
	public Square[][] getBoard(){
		return board;
	}
	
	public static void main(String args[]) {
		
		Board game_board = new Board();
		System.out.println(Arrays.deepToString(game_board.getBoard()));
	}
}
