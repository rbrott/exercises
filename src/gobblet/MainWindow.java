package gobblet;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements Runnable {
	
	public static final int squareWidth = 50;
	
	private int windowWidth, windowHeight;
	
	Board board;

	MainWindow(int gameWidth, int gameHeight) {
		
		windowWidth = gameWidth * squareWidth;
		windowHeight = gameHeight * squareWidth;
		
		board = new Board(gameWidth, gameHeight);
		board.setWhitePlayer(new UserPlayer(Player.WHITE));
		board.setBlackPlayer(new AIPlayer(Player.BLACK));
		
		setSize(windowWidth, windowHeight);
		setTitle("Gobblet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void run() {
		
	}
	
}
