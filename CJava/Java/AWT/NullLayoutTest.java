package AWT;

import java.awt.Button;
import java.awt.Frame;

public class NullLayoutTest {
	Frame f = new Frame("test window");
	Button b1 = new Button("the first button");
	Button b2 = new Button("the second button");
	public void init(){
		f.setLayout(null);
		b1.setBounds(20,30,90,28);
		f.add(b1);
		b2.setBounds(50,45,120,35);
		f.add(b2);
		f.setBounds(50,50,200,100);
		f.setVisible(true);
	}
	public static void main(String[] args){
		new NullLayoutTest().init();
	}
}
