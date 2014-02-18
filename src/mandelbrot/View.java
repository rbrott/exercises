package mandelbrot;

import javax.swing.*;

import java.awt.event.*;

public class View extends JFrame {
	
	Model model;
	
	public View() {
		setSize(750, 750);
		setTitle("Mandelbrot Set");
		model = new Model(750, 750);
		add(model);
		addMouseListener(model);
		addKeyListener(model);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				View window = new View();
			}
		});
	}

}
