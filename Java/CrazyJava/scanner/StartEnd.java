package scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
	public static void main(String[] args){
		String regstr = "Java is easy";
		System.out.println("the aimed word is: " + regstr);
		Matcher m = Pattern.compile("\\w+").matcher(regstr);
		while(m.find()){
			System.out.println(m.group() + "the start of subword: " + m.start() + ", the end of it: " + m.end());
		}
	}
}
