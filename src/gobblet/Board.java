package gobblet;

import java.awt.Color;
import java.awt.Graphics2D;

public class Board {
	
	public static int WHITE = 1, BLACK = 2, NONE = 0; 
	public static final int PIECE_TINY = 1, PIECE_SMALL = 2, PIECE_MEDIUM = 3, PIECE_BIG = 4, PIECE_TOTAL = 5, PIECE_NONE = 0;
	public int[][] unplacedPieces = { {3, 3, 3, 3}, {3, 3, 3, 3} };
	
	private int boardWidth, boardHeight, squareWidth;
	public int[][][][] board;
	public Player white, black;
	public Player currentPlayer;
	
	public Board(int width, int height, int squareWidth) {
		
		this.squareWidth = squareWidth;
		boardWidth = width;
		boardHeight = height;
		
		board = new int[width][height][4][2];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				for(int k = 0; k < 4; k++) {
					board[i][j][k][1] = PIECE_NONE;
					board[i][j][k][0] = NONE;
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
		
		// Draw board
		
		// Draw board pieces
		int x, y, color, size;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				color = -1;
				size = -1;
				x = i * squareWidth;
				y = j * squareWidth;
				for(int k = 0; k < 4; k++) {
					if(board[i][j][k][0] != NONE && board[i][j][k][1] != PIECE_NONE) {
						color = board[i][j][k][0];
						size = board[i][j][k][1];
					}
				}
				if(color != -1 && size != -1) {
					drawPiece(g2d, x + squareWidth, y, color, size);
				}
			}
		}
		// Draw extra pieces
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(unplacedPieces[i][j] > 0) {
					drawPiece(g2d, i * squareWidth * 5, j * squareWidth, i + 1, j + 1);
				}
			}
		}
	} 
	
	private void drawPiece(Graphics2D g2d, int x, int y, int color, int size) {
		int circleWidth = size * squareWidth / PIECE_TOTAL;
		int offset = (squareWidth - circleWidth) / 2;
		g2d.setColor(Color.black);
		if(color == WHITE) {
			g2d.drawOval(x + offset, y + offset, circleWidth, circleWidth);
		} else if(color == BLACK) {
			g2d.fillOval(x + offset, y + offset, circleWidth, circleWidth);
		}
	}
	
	public void update(long delta) {
		
	}
	
}
