/*package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

public class CopySerializable {
	Frame f = new Frame("copy object");
	Button copy = new Button("copy");
	Button paste = new Button("paste");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3,30);
	//create system clipboard
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	public void init(){
		Panel p = new Panel();
		p.add(new Lable("name"));
		p.add(name);
		p.add(new Lable("age"));
		p.add(age);
		f.add(p, BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		copy.addActionListener(e -> copyDog());
		paste.addActionListener(e ->
		{
			try{
				readDog();
			}
			catch (Exception ee){
				ee.printStackTrace();
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.add(bp, BorderLayout.SOUTH;
		f.pack();
		f.setVisible(true);
	}
	public void copyDog()
}*/














