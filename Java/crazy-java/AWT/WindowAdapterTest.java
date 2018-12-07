package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowAdapterTest {
	private Frame f = new Frame("test");
	private TextArea ta = new TextArea(6, 40);
	public void init()
	{
		f.addWindowListener((WindowListener) new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	class MyListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e){
			System.out.println("the user is closing window\n");
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		new WindowAdapterTest().init();
	}
}








