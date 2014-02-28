package gobblet;

import java.awt.Graphics2D;

public class Board {
	
	public static final int PIECE_TINY = 1, PIECE_SMALL = 2, PIECE_MEDIUM = 3, PIECE_BIG = 4, PIECE_EMPTY = 0;

	private int boardWidth, boardHeight;
	public int[][][] board;
	public Player white, black;
	public Player currentPlayer;
	
	public Board(int width, int height) {
		
		boardWidth = width;
		boardHeight = height;
		
		board = new int[width][height][4];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				for(int k = 0; k < 4; k++) {
					board[i][j][k] = PIECE_EMPTY;
				}
			}
		}
		
	}
	
	public void setWhitePlayer(Player p) {
		white = p;
	}
	
	public void setBlackPlayer(Player p) {
		black = p;
	}
	
	public void paint(Graphics2D g2d) {
		
	}
	
	public void update(long delta) {
		
	}
	
}
