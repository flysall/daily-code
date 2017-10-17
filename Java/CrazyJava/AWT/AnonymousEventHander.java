package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnonymousEventHander {
	private Frame f = new Frame("test");
	private TextArea ta = new TextArea(6, 40);

	public void init() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("user tries to close window");
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new AnonymousEventHander().init();
	}
}
