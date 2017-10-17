package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {
	public static void main(String[] args){
		List unmodifiableList = Collections.emptyList();
		Set unmodifiableSet = Collections.singleton("Java teacing");
		Map scores = new HashMap();
		scores.put("chinese", 80);
		scores.put("Java", 82);
		Map unmodifiableMap = Collections.unmodifiableMap(scores);
	}
}
