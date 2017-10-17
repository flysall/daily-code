package scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewFormatterParse {
	public static void main(String[] args)
	{
		String str1 = "2014==04==12 01ʱ06��09��";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HHʱmm��ss��");
		LocalDateTime dt1 = LocalDateTime.parse(str1,formatter1);
		System.out.println(dt1);
	}
}
