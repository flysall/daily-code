package Map;

import java.util.EnumMap;

public class EnumMapTest {
	public static void main(String[] args){
		EnumMap enumMap = new EnumMap(Season.class);
		enumMap.put(Season.SUMMER, "ÏÄÈÕÑ×Ñ×");
		enumMap.put(Season.SPRING , "´ºÅ¯»¨¿ª");
		System.out.println(enumMap);
	}
}
