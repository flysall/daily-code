package collection;

import java.util.TreeSet;

public class TreeSetTest3 {
	public static void main(String[] args){
		TreeSet ts =new TreeSet();
		ts.add(new Re(5));
		ts.add(new Re(-3));
		ts.add(new Re(9));
		ts.add(new Re(-2));
		System.out.println(ts);
		Re first = (Re)ts.first();
		first.count = 20;
		Re last = (Re)ts.last();
		last.count = -2;
		System.out.println(ts);
		System.out.println(ts.remove(new Re(-2)));
		System.out.println(ts);
		System.out.println(ts.remove(new Re(5)));
		System.out.println(ts);
	}
}
