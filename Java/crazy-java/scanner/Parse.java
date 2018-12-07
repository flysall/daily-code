package scanner;

import java.text.DateFormat;
import java.text.ParseException;

public class Parse {
	private static int LONG;

	public static void main(String[] args) throws ParseException{
		String str1 = "2014-12-12";
		String str2 = "2014Äê12ÔÂ10ÈÕ";
		System.out.println(DateFormat.getDateInstance().parse(str1));
		//System.out.println(DateFormat.getDateInstance(LONG).parse(str2));
	}
}
