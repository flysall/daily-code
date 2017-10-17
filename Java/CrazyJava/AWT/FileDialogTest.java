package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;

public class FileDialogTest {
	Frame f = new Frame("test");
	FileDialog d1 = new FileDialog(f, "choose the file", FileDialog.LOAD);
	FileDialog d2 = new FileDialog(f,"choose the path of file", FileDialog.SAVE);
	Button b1 = new Button("open the file");
	Button b2 = new Button("save the file");
	public void init(){
		b1.addActionListener(e -> 
		{
			d1.setVisible(true);
			System.out.println(d1.getDirectory() + d1.getFile());
		});
		b2.addActionListener(e -> 
		{
			d2.setVisible(true);
			System.out.println(d2.getDirectory() + d2.getFile());
		});
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new FileDialogTest().init();
	}
}
