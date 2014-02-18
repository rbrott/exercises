package ulam;

import javax.swing.*;

public class SpiralSurface extends JFrame {
	SpiralSurface(){
		int width = 500;
		int height = width;
		int depth = width / 2;
		SpiralModel spiral = new SpiralModel(depth, width, height);
		add(spiral);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Ulam Spiral");
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				SpiralSurface s = new SpiralSurface();
			}
		});
	}
}
