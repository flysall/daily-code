package Map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args){
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("chinese",  80);
		scores.put("english", 82);
		scores.put("math", 76);
		scores.forEach((key, value) -> System.out.println(key + "-->" + value));
	}
}
