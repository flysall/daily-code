package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CopyPerson {
	Frame f = new Frame("copy object");
	Button copy = new Button("copy");
	Button paste = new Button("paste");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta  = new TextArea(3,30);
	//create local clipboard
	Clipboard clipboard = new Clipboard("cp");
	public void init(){
		Panel p = new Panel();
		p.add(new Label("name"));
		p.add(name);
		p.add(new Label("age"));
		p.add(age);
		f.add(p, BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		//add event listener for button "copy"
		copy.addActionListener(e -> copyPerson());
		//add event listener for button "paste"
		paste.addActionListener(e -> {
			try{
				readPerson();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}); 
		f.add(bp, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public void copyPerson(){
		Person p = new Person(name.getText(), Integer.parseInt(age.getText()));
		LocalObjectSelection ls = new LocalObjectSelection(p);
		clipboard.setContents(ls, null);
	}
	public void readPerson() throws Exception{
		DataFlavor personFlavor = new DataFlavor("application/x-java-jvm-loal-objectref;class=Person");
		if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
			Person p = (Person)clipboard.getData(personFlavor);
			ta.setText(p.toString());
		}
	}
	public static void main(String[] args){
		new CopyPerson().init();
	}
}















