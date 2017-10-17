package AWT;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.BoxLayout;

public class BoxLayoutTest {
	private Frame f = new Frame("test");
	public void init()
	{
		f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
		f.add(new Button("first button"));
		f.add(new Button("second button"));
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new BoxLayoutTest().init();
	}
}
