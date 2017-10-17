package AWT;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;

public class PanelTest {
	public static void main(String[] args){
		Frame f = new Frame("test window");
		Panel p = new Panel();
		p.add(new TextField(100));
		p.add(new Button("click me"));
		f.add(p);
		f.setBounds(30,30,500,120);
		f.setVisible(true);
	}
}
