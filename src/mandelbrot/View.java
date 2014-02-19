package mandelbrot;

import javax.swing.*;

import java.awt.event.*;

public class View extends JFrame {
	
	Model model;
	
	public View() {
		setSize(1000, 1000);
		setTitle("Mandelbrot Set");
		model = new Model(1000, 1000);
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
