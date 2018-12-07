package command;

public class AddCommand implements Command{
	public void process(int[] target){
		int sum = 0;
		for(int tmp : target){
			sum = sum + tmp;
		}
		System.out.println("the sum of array's elements is: " + sum);
	}
}
