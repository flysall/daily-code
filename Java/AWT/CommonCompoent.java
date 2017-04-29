package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;

public class CommonCompoent {
	Frame f = new Frame("test");
	Button ok = new Button("ok");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox male = new Checkbox("man", cbg, true);
	Checkbox female = new Checkbox("woman", cbg, false);
	Checkbox married = new Checkbox("is married?", false);
	Choice colorChooser = new Choice();
	List colorList = new List(6, true);
	TextArea ta = new TextArea(5,20);
	TextField name = new TextField(50);
	public void init()
	{
		colorChooser.add("red");
		colorChooser.add("green");
		colorChooser.add("blue");
		colorChooser.add("red");
		colorChooser.add("green");
		colorChooser.add("blue");
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom, BorderLayout.SOUTH);
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		f.add(top);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new CommonCompoent().init();
	}
}


















