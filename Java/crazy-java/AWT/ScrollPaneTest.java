package AWT;

import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Button;

public class ScrollPaneTest {
	public static void main(String[] args){
	Frame f = new Frame();
	ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
	sp.add(new TextField(20));
	sp.add(new Button("click me"));
	f.add(sp);
	f.setBounds(30,30,250,250);
	f.setVisible(true);
	}
}
