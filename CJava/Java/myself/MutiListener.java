package myself;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MutiListener {
	private Frame f = new Frame("test");
	private TextArea ta = new TextArea(40, 40);
	private Button b1 = new Button("button1");
	private Button b2 = new Button("button2");
	public void init()
	{
		FirstListener f1 = new FirstListener();
		b1.addActionListener(f1);
		b1.addActionListener(new SecondListener());
		b2.addActionListener(f1);
		b2.addActionListener(new SecondListener());
		f.add(ta);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p, BorderLayout.SOUTH );
		f.pack();
		f.setVisible(true);
	}
	class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ta.append("the first event listener is trigger, event source is: " + e.getActionCommand() + "\n");
		}
	}
	class SecondListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ta.append("click¡° " + e.getActionCommand() + "¡° button\n");;
		}
	}
	public static void main(String[] args)
	{
		new MutiListener().init();
	}
}


















