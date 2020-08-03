/**
 * 
 */
package controller;

import View.GameView;
import model.Board;

/**
 * @author spenc
 *
 */
public class Controller {
	
	public Controller() {
		Board game_board = new Board();
		GameView board_view = new GameView(game_board);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Controller();
	}

}
