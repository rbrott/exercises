package gobblet;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private int windowWidth, windowHeight;
	
	Board board;

	MainWindow(int gameWidth, int gameHeight, int squareWidth) {
		
		windowWidth = (gameWidth + 2) * squareWidth;
		windowHeight = gameHeight * squareWidth + 30;
		
		board = new Board(gameWidth, gameHeight, squareWidth);
		board.setWhitePlayer(new UserPlayer(Board.WHITE));
		board.setBlackPlayer(new AIPlayer(Board.BLACK));
		
		add(new JPanel() {
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;
				board.paint(g2d);
			}
		});
		
		setSize(windowWidth, windowHeight);
		setTitle("Gobblet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow window = new MainWindow(4, 4, 100);
			}
		});
	}
	
}
