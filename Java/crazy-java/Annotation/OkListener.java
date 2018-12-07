package Annotation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OkListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "单击了确认按钮");
	}
}
