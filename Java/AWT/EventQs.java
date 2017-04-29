package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs {
	private Frame f = new Frame("test event");
	private Button ok = new Button("ok");
	private TextField tf = new TextField(30);
	public void init()
	{
		ok.addActionListener(new OkListener());
		f.add(tf);
		f.add(ok, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	class OkListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		System.out.println("the user click the ok button");
		tf.setText("Hello World");
		}
	}
	public static void main(String[] args){
		new EventQs().init();
	}
}









