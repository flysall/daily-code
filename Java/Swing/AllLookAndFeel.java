package Swing;

import javax.swing.UIManager;

public class AllLookAndFeel {
	public static void main(String[] args){
		System.out.println("all LAF in current os: ");
		for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName() + "----->" + info);
		}
	}
}
