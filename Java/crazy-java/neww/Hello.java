package neww;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
	public static void main(String[] args){
		Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
		ResourceBundle bundle = ResourceBundle.getBundle("mess" ,  myLocale);
		System.out.println(bundle.getString("hello"));
	}
}
