package scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.Calendar;

public class LenientTest {
	public static void main(String[] args){
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");
		boolean b = m.matches();
		System.out.println(b);
	}
}
