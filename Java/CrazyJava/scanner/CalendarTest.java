package scanner;

import java.util.Calendar;

public class CalendarTest {
	private static final int YEAR = 0;
	private static final int MONTH = 0;
	private static final int DATE = 0;

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(YEAR));
		System.out.println(c.get(MONTH));
		System.out.println(c.get(DATE));
		c.set(2003, 10, 23, 12, 32, 23);
		System.out.println(c.getTime());
		c.add(YEAR, -1);
		System.out.println(c.getTime());
		Calendar call = Calendar.getInstance();
		call.set(2003, 7,23,0,0,0);
		call.add(MONTH, 6);
		System.out.println(c.getTime());
	}
}
