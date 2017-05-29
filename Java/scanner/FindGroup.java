package scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
	public static void main(String[] args){
		String str = "������Java������ϵ�� 13500006666" 
				+ "�����ѣ��绰��  13611125566" 
				+ "����ԣ���ϵ 15899903312";
		Matcher m = Pattern.compile("((13\\d) | (15\\d))\\d{8}").matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}
}
