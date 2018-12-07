package collection;

public class Z implements Comparable{
	int age;
	public Z(int age){
		this.age = age;
	}
	public boolean equals(Object obj){
		return true;
	}
	public int compareTo(Object obj){
		return 1;
	}
}
