package pascal;

import javax.swing.*;

import java.awt.*;

public class TriangleModel extends JPanel {
	int x1, y1, x2, y2, x3, y3, depth;
	TriangleModel(int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.depth = depth;
	}
	void drawTriangle(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
		if(depth == 1) {
			g2d.drawLine(x1, y1, x2, y2);
			g2d.drawLine(x2, y2, x3, y3);
			g2d.drawLine(x3, y3, x1, y1);
		} else {
			int tx1 = (x1 + x3) / 2, ty1 = (y1 + y3) / 2, tx2 = (x1 + x2) / 2, ty2 = (y1 + y2) / 2, tx3 = x1, ty3 = y2;
			drawTriangle(g2d, x1, y1, tx2, ty2, tx1, ty1, depth - 1);
			drawTriangle(g2d, tx1, ty1, tx3, ty3, x3, y3, depth - 1);
			drawTriangle(g2d, tx2, ty2, x2, y2, tx3, ty3, depth - 1);
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		drawTriangle(g2d, x1, y1, x2, y2, x3, y3, depth);
	}
}
