package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class SimpleDraw {
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	private Frame f = new Frame("SimpleDraw");
	private Button rect = new Button("draw rectangle");
	private Button oval = new Button("draw oval");
	private MyCanvas drawArea = new MyCanvas();
	// save the variable for drawing
	private String shape = " ";

	public void init() {
		Panel p = new Panel();
		rect.addActionListener(e -> {
			shape = RECT_SHAPE;
			drawArea.repaint();
		});
		oval.addActionListener(e -> {
			shape = OVAL_SHAPE;
			drawArea.repaint();
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250, 180));
		f.add(drawArea);
		f.add(p, BorderLayout.SOUTH);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] arg) {
		new SimpleDraw().init();
	}

	class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			Random rand = new Random();
			if (shape.equals(RECT_SHAPE)) {
				g.setColor(new Color(230, 100, 80));
				g.drawRect(rand.nextInt(200), rand.nextInt(120), 60, 60);
			}
			if (shape.equals(OVAL_SHAPE)) {
				g.setColor(new Color(80, 100, 200));
				g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
			}
		}
	}
}
