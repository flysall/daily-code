package AWT;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Button;

import javax.swing.Box;

public class BoxSpaceTest {
	private Frame f = new Frame("test");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	public void init(){
		horizontal.add(new Button("horizontal button1"));
		horizontal.add(new Button("horizontal button2"));
		horizontal.add(new Button("horizontal button3"));
		vertical.add(new Button("vertical button1"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("vertical button2"));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("vertical button3"));
		f.add(horizontal, BorderLayout.NORTH );
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new BoxSpaceTest().init();
	}
}
