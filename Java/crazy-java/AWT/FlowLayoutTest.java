package AWT;

import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.Button;

public class FlowLayoutTest {
	public static void main(String[] args){
		Frame f = new Frame("test window");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,500,50));
		for(int i = 0; i < 10; i++){
			f.add(new Button("button" + i));
		}
		f.pack();
		f.setVisible(true);
	}
}
