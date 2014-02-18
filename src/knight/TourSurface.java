package knight;

import javax.swing.*;

import pascal.TriangleSurface;

public class TourSurface extends JFrame {
	TourSurface() {
		TourModel m = new TourModel(8, 8);
		add(m);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Knight's Tour");
		setSize((8 + 1) * 50, (8 + 1) * 50);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TourSurface s = new TourSurface();
			}
		});
	}
}
