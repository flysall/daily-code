package scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class NewFormattterTest {
	public static void main(String[] args){
		DateTimeFormatter[] formatters = new DateTimeFormatter[]{
				DateTimeFormatter.ISO_LOCAL_DATE,
				DateTimeFormatter.ISO_LOCAL_TIME,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME,
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.MEDIUM),
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
				DateTimeFormatter.ofPattern("Gyyyy%%MM%%dd HH:mm:ss")
		};
		LocalDateTime date = LocalDateTime.now();
		for(int i = 0; i < formatters.length; i++){
			System.out.println(date.format(formatters[i]));
		}
	}
}





