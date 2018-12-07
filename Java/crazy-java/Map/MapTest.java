package Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args){
	Map map = new HashMap();
	map.put("Java teaching", 109);
	map.put("iOS teaching", 10);
	map.put("Ajax teaching", 79);
	map.put("Java EE", 99);
	System.out.println(map.put("iOS teaching", 99));
	System.out.println(map);
	System.out.println("是否包含值为99的value: " 
			+ map.containsValue(99));
	for(Object key : map.keySet()){
		System.out.println(key + "-->" + map.get(key));
	}
	map.remove("Ajax teaching");
	System.out.println(map);
	}
}
