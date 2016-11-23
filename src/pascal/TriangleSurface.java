package pascal;

import javax.swing.*;

import ulam.SpiralSurface;

import java.awt.*;

public class TriangleSurface extends JFrame {
	TriangleSurface() {
		int scale = 750;
		int x1 = scale / 2, y1 = 0, x2 = scale, y2 = (int) Math.floor(Math.sqrt(3.0) * (scale / 2)), x3 = 0, y3 = (int) Math.floor(Math.sqrt(3.0) * (scale / 2)), depth = 10;
		TriangleModel m = new TriangleModel(x1, y1, x2, y2, x3, y3, depth);
		add(m);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pascal Triangles");
		setSize(scale, scale);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TriangleSurface s = new TriangleSurface();
			}
		});
	}
}
