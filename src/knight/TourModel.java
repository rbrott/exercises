package knight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TourModel extends JPanel {
	private ArrayList<Point> list;
	public int width, height;
	TourModel(int width, int height) {
		this.height = height;
		this.width = width;
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(0,0));
		this.list = iterateMoves(width, height, list, 1);
	}
	int[][] nextMove(int startX, int startY) {
		int[][] poss = {{startX + 1, startY - 2},
					  {startX + 2, startY - 1},
					  {startX + 2, startY + 1},
					  {startX + 1, startY + 2},
					  {startX - 1, startY + 2},
					  {startX - 2, startY + 1},
					  {startX - 2, startY - 1},
					  {startX - 1, startY - 2}};
		return poss;
	}
	private boolean contains(ArrayList<Point> list, int x, int y) {
		for(Point p : list) {
			if(p.getX() == x && p.getY() == y) {
				return true;
			}
		}
		return false;
	}
	ArrayList<Point> iterateMoves(int width, int height, ArrayList<Point> list, int start) {
		Point p = list.get(list.size() - 1);
		int startX = p.getX(), startY = p.getY();
		int[][] poss = nextMove(startX, startY);
	    if(startX < 0 || startY < 0 || startX >= width || startY >= height) {
	    	return null;
	    } else {
	    	if(start == (width * height)) {
	    		return list;
	    	}
	    }
		for(int i = 0; i < poss.length; i++) {
			if(!contains(list, poss[i][0], poss[i][1])) {
				ArrayList<Point> temp = (ArrayList<Point>) list.clone();
				temp.add(new Point(poss[i][0], poss[i][1]));
				temp = iterateMoves(width, height, temp, start + 1);
				if(temp != null) {
					return temp;
				}
			}
		}
        return null;
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Point lastPoint = null;
		int cX, cY;
		if(this.list != null) {
			for(int i = 0; i <= width; i++) {
				g2d.drawLine(0, i * 50, width * 50, i * 50);
			}
			for(int j = 0; j <= height; j++) {
				g2d.drawLine(j * 50, 0, j * 50, height * 50);;
			}
			g2d.setStroke(new BasicStroke(5));
			for(Point p : this.list) {
				cX = p.getX() * 50;
				cY = p.getY() * 50;
				g2d.drawOval(cX + 20, cY + 20, 10, 10);
				if(lastPoint != null) {
					g2d.drawLine(lastPoint.getX() * 50 + 25, lastPoint.getY() * 50 + 25, cX + 25, cY + 25);
				}
				lastPoint = p;
			}
		} else {
			g2d.drawString("No solutions", 10, 10);
		}
	}
}
