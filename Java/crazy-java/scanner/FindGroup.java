package scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
	public static void main(String[] args){
		String str = "我想买《Java》，联系我 13500006666" 
				+ "交朋友，电话是  13611125566" 
				+ "买电脑，联系 15899903312";
		Matcher m = Pattern.compile("((13\\d) | (15\\d))\\d{8}").matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}
}
