package Annotation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CancelListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "单击了取消按钮");
	}
}
