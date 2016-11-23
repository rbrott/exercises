package gameoflife;

public class Board {
	
	private boolean[][] state, nextState;
	private int rows, cols;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		state = new boolean[rows][cols];
		nextState = new boolean[rows][cols];
	}
	
	public static Board random(int rows, int cols) {
		Board board = new Board(rows, cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board.state[i][j] = Math.random() > 0.5;
			}
		}
		return board;
	}
	
	public static Board fromAlive(int rows, int cols, int[][] points) {
		Board board = new Board(rows, cols);
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			int row = point[0];
			int col = point[1];
			board.state[row][col] = true;
		}
		return board;
	}
	
	public Board copy() {
		Board board = new Board(rows, cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board.state[i][j] = state[i][j];
			}
		}
		return board;
	}
	
	public int getCols() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public boolean[][] getState() {
		return state;
	}
	
	public boolean isInside(int row, int col) {
		return row >= 0 && col >= 0 && row < rows && col < cols;
	}
	
	public void setCell(int row, int col, boolean value) {
		if (isInside(row, col)) {
			state[row][col] = value;
		}
	}
	
	public boolean getCell(int row, int col) {
		if (isInside(row, col)) {
			return state[row][col];			
		} else {
			return false;
		}
	}
	
	public void shiftState() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				state[i][j] = nextState[i][j];
				nextState[i][j] = false;
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int aliveCount = 0;
				for (int[] neighbor : getNeighbors(i, j)) {
					int nRow = neighbor[0];
					int nCol = neighbor[1];
					if (getCell(nRow, nCol)) {
						aliveCount++;
					}
				}
				if ((state[i][j] && aliveCount == 2) || aliveCount == 3) {
					nextState[i][j] = true;
				} else {
					nextState[i][j] = false;
				}
			}
		}
		shiftState();
	}
	
	public static int[][] getNeighbors(int row, int col) {
		int[][] neighbors = {
				{ row, col - 1 },
				{ row + 1, col - 1 },
				{ row + 1, col },
				{ row + 1, col + 1 },
				{ row, col + 1 },
				{ row - 1, col + 1 },
				{ row - 1, col },
				{ row - 1, col - 1 }
		};
		return neighbors;
	}
	
}
