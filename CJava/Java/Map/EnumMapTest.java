package Map;

import java.util.EnumMap;

public class EnumMapTest {
	public static void main(String[] args){
		EnumMap enumMap = new EnumMap(Season.class);
		enumMap.put(Season.SUMMER, "��������");
		enumMap.put(Season.SPRING , "��ů����");
		System.out.println(enumMap);
	}
}
