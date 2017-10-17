package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class SimpleClipboard {
	private Frame f = new Frame("Simple clipboard program");
	// get the os's clipboard
	private Clipboard Clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	// create a new local clipboard
	Clipboard clipboard = new Clipboard("cb");
	// the textfield for copying
	private TextArea jtaCopyTo = new TextArea(5, 20);
	// the textarea for pasting
	private TextArea jtaPaste = new TextArea(5, 20);
	private Button btCopy = new Button("copy");
	private Button btPaste = new Button("paste");

	public void init() {
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(event -> {
			// package a String to StringSelection object
			StringSelection contents = new StringSelection(jtaCopyTo.getText());
			// move the StringSelection object to the clipboard
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event -> {
			// if the clipboard contains the stringFlavaor
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try {
					String content = (String) clipboard.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);
		// add two TextArea to the Box container
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(p, BorderLayout.SOUTH);
		f.add(box, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleClipboard().init();
	}
}
