package collection;

import java.util.stream.IntStream;

public class IntStreamTest {
	public static void main(String[] args){
		IntStream is = IntStream.builder()
				.add(20)
				.add(13)
				.add(-2)
				.add(18)
				.build();
		//System.out.println("the max of is: " + is.max().getAsInt());
		/*System.out.println("the min of is: " + is.min().getAsInt());
		System.out.println("the sum of is: " + is.sum());
		System.out.println("the count of is: " + is.count());
		System.out.println("the average of is: " + is.average());
		System.out.println("Are the elements square of is all bigger than 20: " 
				+is.allMatch(ele -> ele * ele > 20));
		System.out.println("is 是否包含任何元素的 平方大于20: " 
				+ is.anyMatch(ele -> ele *ele > 20)); */
		IntStream newIs = is.map(ele -> ele * 2 + 1);
		newIs.forEach(System.out::println);
	}
}










