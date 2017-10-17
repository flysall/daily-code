package collection;

import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args){
		TreeSet set = new TreeSet();
		Z z1 = new Z(6);
		set.add(z1);
		System.out.print(set.add(z1));
		System.out.println(set);
		((Z)set.first()).age = 9;
		System.out.println(((Z)(set.last())).age);
	}
}
