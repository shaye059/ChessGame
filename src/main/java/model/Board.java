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
		String temp_colour = "White";
		for(int row = 0; row <= 7; row++) {
			for(int column = 0; column<= 7; column++) {
				Piece square_piece = null;
				
				//mark light squares
				if ((row+column)%2 == 0) {
					temp_colour = "White";
				}
				
				//mark dark square
				if ((row+column)%2 == 1) {
					temp_colour = "Black";
				}
				
				//setup black pieces in initial positions
				if (row*8 + column == 0 || row*8 + column == 7) {
					
					square_piece = new Castle("Black");
				}
				if(row*8 + column == 1 || row*8 + column == 6) {
					square_piece = new Rook("Black");
				}
				if(row*8 + column == 2 || row*8 + column == 5) {
					square_piece = new Bishop("Black");
				}
				if(row*8 + column == 3) {
					square_piece = new Queen("Black");
				}
				if(row*8 + column == 4) {
					square_piece = new King("Black");
				}
				if(row == 1) {
					square_piece = new Pawn("Black");
				}
				
				//setup white pieces in initial position
				if (row*8 + column == 56 || row*8 + column == 63) {
					
					square_piece = new Castle("White");
				}
				if(row*8 + column == 57 || row*8 + column == 62) {
					square_piece = new Rook("White");
				}
				if(row*8 + column == 58 || row*8 + column == 61) {
					square_piece = new Bishop("White");
				}
				if(row*8 + column == 59) {
					square_piece = new Queen("White");
				}
				if(row*8 + column == 60) {
					square_piece = new King("White");
				}
				if(row == 6) {
					square_piece = new Pawn("White");
				}
				
				Pair<Integer,Integer> space = new Pair<Integer,Integer>(row,column);
				board[row][column] = new Square(temp_colour, space, square_piece);
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
