package Map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumreationTest {
	public static void main(String[] args){
		Vector v = new Vector();
		v.add("Java teaching");
		v.add("Java EE");
		Hashtable scores  = new Hashtable();
		scores.put("chinese", 78);
		scores.put("math", 88);
		Enumeration em = v.elements();
		while(em.hasMoreElements()){
			System.out.println(em.nextElement());
		}
		Enumeration keyEm = scores.keys();
		while(keyEm.hasMoreElements()){
			Object key = keyEm.nextElement();
			System.out.println(key + "-->" + scores.get(key));
		}
	}
}
