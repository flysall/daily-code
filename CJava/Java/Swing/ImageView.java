package Swing;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;


public class ImageView {
	//define the size of picture-pare component
	final int PREVIEW_SIZE = 100;
	JFrame jf = new JFrame("Simple");
	JMenuBar menuBar = new JMenuBar();
	//this label is used to display picture
	JLabel label = new JLabel();
	//create file filter in current path
	JFileChooser chooser = new JFileChooser(".");
	JLabel accessory = new JLabel();
	//define file filter
	ExtensionFilter filter = new ExtensionFilter();
	public void init(){
		//----------下面开始初始化JFileChooser的相关属性--------
		//create a FileFilter
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("picture file(*.jpg, *.jpeg, *.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		//ban the "file type" label displaying "all files" option
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileView(new FileIconView(filter));
		chooser.setAccessory(accessory);
		accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
		accessory.setBorder(BorderFactory.createEtchedBorder());
		chooser.addPropertyChangeListener(event -> {
			if(event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
				File f = (File) event.getNewValue();
				if (f == null){
					accessory.setIcon(null);
					return;
				}
				//import the files to the ImageIcon object
				ImageIcon icon = new ImageIcon(f.getPath());
				//if the Icon is too big, make it small
				if(icon.getIconWidth() > PREVIEW_SIZE){
					icon = new ImageIcon(icon.getImage().getScaledInstance(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
				}
				//change the icon of accessory label
				accessory.setIcon(icon);
			}
		});
		//下面的代码开始为该程序窗口安装菜单
		JMenu menu = new JMenu("file");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("open");
		menu.add(openItem);
		menu.add(openItem);
		openItem.addActionListener(event -> 
		{
			//set the current path of file dialog
			//display the file dialog
			int result = chooser.showDialog(jf, "open picture file");
			if(result == JFileChooser.APPROVE_OPTION){
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		});
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(event -> System.exit(0));
		jf.setJMenuBar(menuBar);
		jf.add(new JScrollPane(label));
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args){
		new ImageView().init();
	}
}













