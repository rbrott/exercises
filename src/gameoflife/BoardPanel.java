package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	private Board board;
	private BoardUpdater updater;
	private int cellWidth, cellHeight;
	
	public BoardPanel(Board board) {
		this.board = board;
		this.updater = new BoardUpdater();
	}
	
	public synchronized void swapBoard(Board newBoard) {
		this.board = newBoard;
		repaint();
	}
	
	public void start() {
		this.updater.start();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.DARK_GRAY);
		
		int rows = board.getRows();
		int cols = board.getCols();
		
		int width = this.getWidth();
		int height = this.getHeight();
		cellWidth = width / cols;
		cellHeight = height / rows;

		g2d.clearRect(0, 0, width, height);
		
		boolean[][] state = board.getState();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (state[i][j]) {
					g2d.fillRect(cellWidth * j, cellHeight * i, cellWidth, cellHeight);
				} else {
					g2d.drawRect(cellWidth * j, cellHeight * i, cellWidth, cellHeight);
				}
			}
		}
	}
	
	public void toggle() {
		if (isPaused()) {
			play();
		} else {
			pause();
		}
	}
	
	public void step() {
		updater.update();
	}
	
	public void pause() {
		updater.pause();
	}
	
	public void play() {
		updater.play();
	}
	
	public boolean isPaused() {
		return updater.isPaused();
	}
	
	public void mouseClick(Point p) {
		int row = (int) (p.getY() / cellHeight);
		int col = (int) (p.getX() / cellWidth);
		board.setCell(row, col, !board.getCell(row, col));
		repaint();
	}
	
	public class BoardUpdater extends Thread {
		
		private boolean paused = false;
		
		@Override
		public void run() {
			long msPerLoop = 100;
			while (true) {
				if (paused) {
					Thread.yield();
				} else {
					long startTime = System.currentTimeMillis();
					update();
					while ((System.currentTimeMillis() - startTime) < msPerLoop) {
						try {
							Thread.sleep(0, 250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		public void update() {
			BoardPanel.this.repaint();
			synchronized(BoardPanel.this) {
				board.update();
			}
		}
		
		public boolean isPaused() {
			return paused;
		}
		
		public void pause() {
			paused = true;
		}
		
		public void play() {
			paused = false;
		}
		
	}

}
