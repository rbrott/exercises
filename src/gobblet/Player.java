package gobblet;

import java.awt.Graphics2D;

public interface Player {
	
	public static int WHITE = 0, BLACK = 1;
	
	void update(long delta);
	void paint(Graphics2D g2d);

}
