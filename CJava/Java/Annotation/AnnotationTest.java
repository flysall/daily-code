package Annotation;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnnotationTest {
	private JFrame mainWin = new JFrame("ʹ��ע����¼�������");
	@ActionListenerFor(listener = OkListener.class)
	private JButton ok = new JButton("ok");
	@ActionListenerFor(listener = CancelListener.class)
	private JButton cancel = new JButton("cancel");
	public void init(){
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args){
		new AnnotationTest().init();
	}
}
