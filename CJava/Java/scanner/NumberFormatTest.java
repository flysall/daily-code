package scanner;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
	public static void main(String[] args) {
		double db = 12340000.567;
		Locale[] locales = { Locale.CHINA, Locale.JAPAN, Locale.GERMAN, Locale.US };
		NumberFormat[] nf = new NumberFormat[12];
		for (int i = 0; i < locales.length; i++) {
			nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
			nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
			nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
		}
		for (int i = 0; i < locales.length; i++) {
			String tip = i == 0 ? "----the format of China----"
					: i == 1 ? "----the format of Japan----"
							: i == 2 ? "----the format of German----" : "----the format of America";
			System.out.println(tip);
			System.out.println("Universal Numeric Format: " + nf[i * 3].format(db));
			System.out.println("Percentage Numeric Format: " + nf[i * 3 + 1].format(db));
			System.out.println("Currency Numeric Format: " + nf[i * 3 + 2].format(db));
		}
	}
}
