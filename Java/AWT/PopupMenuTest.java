package AWT;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopupMenuTest {
	private TextArea ta = new TextArea(4, 30);
	private Frame f = new Frame("test");
	PopupMenu pop = new PopupMenu();
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("auto wrap");
	MenuItem copyItem = new MenuItem("copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu format = new Menu("format");
	MenuItem commentItem = new MenuItem("comment", new MenuShortcut(KeyEvent.VK_SLASH, true)); //
	MenuItem cancelItem = new MenuItem("cancel commet");

	public void init()
	{
		ActionListener menuListener = e -> 
		{
			String cmd = e.getActionCommand();
			ta.append("click¡°" + "cmd" + "¡°menu" + "\n");
			if(cmd.equals("Exit")){
				System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		pop.add(autoWrap);
		pop.addSeparator();
		pop.add(copyItem);
		pop.add(pasteItem);
		format.add(commentItem);
		format.add(cancelItem);
		pop.add(new MenuItem("-"));
		pop.add(format);
		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300, 160)); //
		p.add(pop);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(p, e.getX(), e.getY());
				}
			}
		});
		f.add(p);
		f.add(ta, BorderLayout.NORTH );
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args){
		new PopupMenuTest().init();
	}
}











