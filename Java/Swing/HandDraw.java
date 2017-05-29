package Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class HandDraw {
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 400;
	private int preX = -1;
	private int preY = -1;
	JPopupMenu pop = new JPopupMenu();
	JMenuItem chooseColor = new JMenuItem("choose color");
	BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	private JFrame f = new JFrame("simple hand draw program");
	private DrawCanvas drawArea = new DrawCanvas();
	// for save the color of brush
	private Color foreColor = new Color(255, 0, 0);

	public void init() {
		chooseColor.addActionListener(ae -> {
			final JColorChooser colorPane = new JColorChooser(foreColor);
			JDialog jd = JColorChooser.createDialog(f, "chooose color of brush", false, colorPane,
					e -> foreColor = colorPane.getColor(), null);
			jd.setVisible(true);
		});
		// Combine menu items into right-click menus
		pop.add(chooseColor);
		drawArea.setComponentPopupMenu(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		// Listen to mouse movements
		drawArea.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (preX > 0 && preY > 0) {
					// set current color
					g.setColor(foreColor);
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				// save the current position of X Y
				preX = e.getX();
				preY = e.getY();
				drawArea.repaint();
			}
		});
		// listen to mouse event
		drawArea.addMouseListener(new MouseAdapter() {
			// achieve the event process for releasing mouse
			public void mouseReleased(MouseEvent e) {
				preX = -1;
				preY = -1;
			}
		});
		f.add(drawArea);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new HandDraw().init();
	}

	// the DrawCanvs inherit JPanel class
	class DrawCanvas extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}
}
