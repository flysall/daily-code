package flysall.strings;

import java.util.regex.*;

public class Reflags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while(m.find()) {
            System.out.println(m.group());
        }
        System.out.println("--------Without Pattern.MULTILINE--------");
        Pattern p2 = Pattern.compile("^java", Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while(m2.find()) {
            System.out.println(m2.group());
        }
    }
}
