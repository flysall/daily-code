package myself;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest {
	private Frame f = new Frame();
	private TextArea ta = new TextArea(6, 40);

	public void init() {
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}

	class MyListener implements WindowListener {
		public void windowOpened(WindowEvent e) {
			ta.append("the window is opened firstly\n");
		}

		public void windowActivated(WindowEvent e) {
			ta.append("The window is activated!\n");
		}

		public void windowClosed(WindowEvent e) {
			ta.append("The window is closed\n");
		}

		public void windowClosing(WindowEvent e) {
			ta.append("The window is closing!\n");
			System.exit(0);
		}

		public void windowDeactivated(WindowEvent e) {
			ta.append("the window loses the deactivateion!\n");
		}

		public void windowDeiconified(WindowEvent e) {
			ta.append("the window is reset!\n");
		}

		public void windowIconified(WindowEvent e) {
			ta.append("the window is mining!\n");
		}
	}

	public static void main(String[] args) {
		new WindowListenerTest().init();
	}
}
