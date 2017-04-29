package AWT;

import java.awt.Frame;

public class FrameTest {
	public static void main(String[] args){
		Frame f = new Frame("test window");
		f.setBounds(30,30,250,200);
		f.setVisible(true);
	}
}
