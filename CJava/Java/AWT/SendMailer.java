package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

public class SendMailer {
	private Frame f = new Frame("Gmail");
	private TextField tf = new TextField(40);
	private Button send = new Button("send");
	public void init()
	{
		send.addActionListener(new MailerListener(tf));
		f.add(tf);
		f.add(send, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SendMailer().init();
	}
}










