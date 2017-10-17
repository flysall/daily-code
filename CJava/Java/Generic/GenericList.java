package Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericList {
	public static void main(String[] args){
		List<String> strList = new ArrayList<String>();
		strList.add("Java teaching");
		strList.add("Android");
		strList.forEach(str -> System.out.println(str.length()));
	}
}
