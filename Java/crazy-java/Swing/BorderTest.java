package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
	private JFrame jf = new JFrame("test border");

	public void init(){
		jf.setLayout(new GridLayout(2,4));
		//create BevelBorder in static BorderFactory
		Border bb = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
		jf.add(getPanelWithBorder(bb, "BevelBorder"));
		//create LineBorder in static BorderFactory
		Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
		jf.add(getPanelWithBorder(lb,"LineBorder"));
		//create EmptyBorder in static BorderFactory
		Border eb = BorderFactory.createEmptyBorder(20,5,10,30);
		jf.add(getPanelWithBorder(eb, "EmptyBorder"));
		//create EtchedBorder in static BorderFactory
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.GREEN, Color.RED);
		jf.add(getPanelWithBorder(etb, "EtchecBorder"));
		//create TitledBorder directly
		TitledBorder tb = new TitledBorder(lb, "test title", TitledBorder.LEFT ,TitledBorder.BOTTOM
				,new Font("StSong", Font.BOLD , 18), Color.BLUE );
		jf.add(getPanelWithBorder(tb, "TitledBorder"));
		MatteBorder mb = new MatteBorder(20, 5, 10, 30, Color.GREEN);
		jf.add(getPanelWithBorder(mb,"MatteBorder"));
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED, 8), tb);
		jf.add(getPanelWithBorder(cb, "CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderTest().init();
	}

	public JPanel getPanelWithBorder(Border b, String BorderName) {
		JPanel p = new JPanel();
		p.add(new JLabel(BorderName));
		p.setBorder(b);
		return p;
	}
}
