package AWT;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
	private Frame f = new Frame("test");
	private MenuBar mb = new MenuBar();
	Menu file = new Menu("file");
	Menu edit = new Menu("edit");
	MenuItem newItem = new MenuItem("New");
	MenuItem saveItem = new MenuItem("Save");
	MenuItem exitItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto Wrap");
	MenuItem copyItem = new MenuItem("copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu format = new Menu("format");
	MenuItem commentItem = new MenuItem("comment", new MenuShortcut(KeyEvent.VK_SLASH, true)); //
	MenuItem cancelItem = new MenuItem("cancel commet");
	private TextArea ta = new TextArea(6, 40);

	public void init() {
		ActionListener menuListener = e -> {
			String cmd = e.getActionCommand();
			ta.append("click¡°" + cmd + "¡±Menu" + "\n");
			if (cmd.equals("Exit")) {
				System.exit(0);
			}
		};

		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		file.add(autoWrap);

		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);

		format.add(commentItem);
		edit.add(new MenuItem("-"));
		format.add(cancelItem);
		edit.add(format);

		mb.add(file);
		mb.add(edit);

		f.setMenuBar(mb);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleMenu().init();
	}
}
