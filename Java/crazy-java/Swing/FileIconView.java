package Swing;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class FileIconView extends FileView{
	private FileFilter filter;
	public FileIconView(FileFilter filter){
		this.filter = filter;
	}
	public Icon getIcon(File f){
		if(!f.isDirectory() && filter.accept(f)){
			return new ImageIcon("ico/pict.png");
		}
		else if(f.isDirectory()){
			File[] fList = File.listRoots();
			for(File tmp : fList){
				if(tmp.equals(f)){
					return new ImageIcon("ico/dsk.png");
				}
			}
			return new ImageIcon("ico/folder.png");
		}
		else{
			return null;
		}
	}
}
