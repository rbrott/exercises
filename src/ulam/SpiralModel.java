package ulam;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class SpiralModel extends JPanel {
	int depth;
	ArrayList<Point> points = new ArrayList<Point>();
	boolean[] positive = {true, false, false, true};
	boolean primeTest(int n) {
		int lim = (int) Math.floor(Math.sqrt((double) n));
		if(n == 1){
			return false;
		}
		for(int i = 2; i <= lim; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	SpiralModel(int depth, int width, int height) {
		this.depth = depth;
		int x, y;
		x = (int) Math.floor(width / 2);
		y = (int) Math.floor(height / 2);
		int num = 1;
		int v;
		int c;
		for(int i = 0; i < depth; i++) {
			for(int j = 0; j < 4; j++) {
				if(j < 2) {
					v = 2 * i + 1;
				} else {
					v = 2 * i + 2;
				}
				c = 0;
				while(c < v){
					if(primeTest(num)) {
						points.add(new Point(x, y));
					}
	
					if(positive[j]) {
						if(j % 2 == 0){
							x += 1;
						} else {
							y += 1;
						}
					} else {
						if(j % 2 == 0){
							x -= 1;
						} else {
							y -= 1;
						}
					}
					c++;
					num++;
				}
			}
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// g2d.setColor(new Color((float) 1.0, (float) 0.35, (float) 0.0));
		for(Point p : this.points) {
			g2d.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
		}
	}
}
