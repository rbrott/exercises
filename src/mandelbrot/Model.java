package mandelbrot;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Model extends JPanel implements KeyListener, MouseListener {

	int width, height;
	//double cx = 112000.0, cy = 112000.0, zoom = 320000.0;
	double cx = 0.0, cy = 0.0, zoom = 200.0;
	int[][] set;
	
	public Model(int width, int height) {
		this.width = width;
		this.height = height;
		set = new int[width][height];
		calculateSet();
	}
	
	private void calculateSet() {
		for(int i = 0; i < set.length; i++) {
			for(int j = 0; j < set[i].length; j++) {
				set[i][j] = calculateNum(i, j);
			}
		}
	}
	
	private int calculateNum(int x, int y) {
		Complex complex = new Complex(((x - (double) width / 2) + cx) / zoom, (((double) height / 2 - y) + cy) / zoom);
		Complex result = new Complex(complex);
		for(int k = 0; k < 100; k++) {
			result = result.multiply(result).add(complex);
			if(Math.abs(result.getImag()) > 2.0 || Math.abs(result.getReal()) > 2.0) {
				return k + 1;
			}
		}
		return 0;
	}

	public void paint(Graphics g) {
		super.paint(g);
		int k;
		Graphics2D g2d = (Graphics2D) g;
		for(int i = 0; i < set.length; i++) {
			for(int j = 0; j < set[i].length; j++) {
				k = set[i][j];
				if(k == 0) g2d.setColor(Color.black);
				else if (k < 10) g2d.setColor(Color.red);
				else if (k < 20) g2d.setColor(Color.orange);
				else if (k < 30) g2d.setColor(Color.yellow);
				else if (k < 40) g2d.setColor(Color.green);
				else if (k < 50) g2d.setColor(Color.blue);
				else if (k < 60) g2d.setColor(Color.magenta);
				else if (k < 70) g2d.setColor(Color.pink);
				else if (k < 80) g2d.setColor(Color.cyan);
				else if (k < 90) g2d.setColor(Color.lightGray);
				else g2d.setColor(Color.gray);
				g2d.drawLine(i, j, i, j);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int button = e.getButton();
		switch(button) {
		case MouseEvent.BUTTON1:
			zoom *= 2.0;
			break;
		case MouseEvent.BUTTON3:
			zoom /= 2.0;
			break;
		}
		calculateSet();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT:
			cx += 20.0;
			break;
		case KeyEvent.VK_RIGHT:
			cx -= 20.0;
			break;
		case KeyEvent.VK_UP:
			cy -= 20.0;
			break;
		case KeyEvent.VK_DOWN:
			cy += 20.0;
			break;
		}
		calculateSet();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
