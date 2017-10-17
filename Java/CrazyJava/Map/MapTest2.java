package Map;

import java.util.Map;
import java.util.HashMap;
public class MapTest2 {
	public static void main(String[] args){
		Map map = new HashMap();
		map.put("Java teaching", 109);
		map.put("iOS teaching", 99);
		map.put("Ajax teaching", 79);
		map.replace("XML teaching", 66);
		System.out.println(map);
		map.merge("iOS teaching", 10, (oldVal,param) -> (Integer)oldVal + (Integer)param);
		System.out.println(map);
		map.computeIfAbsent("Java", (key)->((String)key).length());
		System.out.println(map);
		map.computeIfPresent("Java", (key,value) -> (Integer)value * (Integer)value);
		System.out.println(map);
	}
}
