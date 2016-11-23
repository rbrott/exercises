package gameoflife;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameWindow extends JFrame implements KeyListener, MouseListener {
	
	public static final Board GLIDER_GUN = Board.fromAlive(40, 40, new int[][] {
		{ 1, 25 },
		{ 2, 23 },
		{ 2, 25 },
		{ 3, 13 },
		{ 3, 14 },
		{ 3, 21 },
		{ 3, 22 },
		{ 3, 35 },
		{ 3, 36 },
		{ 4, 12 },
		{ 4, 16 },
		{ 4, 21 },
		{ 4, 22 },
		{ 4, 35 },
		{ 4, 36 },
		{ 5, 1 },
		{ 5, 2 },
		{ 5, 11 },
		{ 5, 17 },
		{ 5, 21 },
		{ 5, 22 },
		{ 6, 1 },
		{ 6, 2 },
		{ 6, 11 },
		{ 6, 15 },
		{ 6, 17 },
		{ 6, 18 },
		{ 6, 23 },
		{ 6, 25 },
		{ 7, 11 },
		{ 7, 17 },
		{ 7, 25 },
		{ 8, 12 },
		{ 8, 16 },
		{ 9, 13 },
		{ 9, 14 }
	});
	
	private BoardPanel boardPanel;
	private Board board;
	
	public GameWindow() {
		board = new Board(40, 40);
		
		boardPanel = new BoardPanel(board);
		add(boardPanel);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu loadMenu = new JMenu("Load");
		
		JMenuItem loadEmpty = new JMenuItem("Empty");
		loadEmpty.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boardPanel.pause();
				boardPanel.swapBoard(new Board(40, 40));
			}
			
		});
		
		JMenuItem loadRandom = new JMenuItem("Random");
		loadRandom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boardPanel.pause();
				boardPanel.swapBoard(Board.random(40, 40));
			}
			
		});
		
		JMenuItem loadGliderGun = new JMenuItem("Glider Gun");
		loadGliderGun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boardPanel.pause();
				boardPanel.swapBoard(GLIDER_GUN.copy());
			}
			
		});
		
		loadMenu.add(loadEmpty);
		loadMenu.add(loadRandom);
		loadMenu.add(loadGliderGun);
		
		menuBar.add(loadMenu);
		
		setJMenuBar(menuBar);
		
		addKeyListener(this);
		addMouseListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Game of Life");
		setResizable(true);
		setSize(1000, 1000);
		setVisible(true);
		
		boardPanel.start();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameWindow window = new GameWindow();
			}
		});
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			boardPanel.step();
			break;
		case KeyEvent.VK_SPACE:
			boardPanel.toggle();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point origin = boardPanel.getLocationOnScreen();
		boardPanel.mouseClick(new Point(e.getX() - (int) origin.getX(), e.getY() - (int) origin.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
