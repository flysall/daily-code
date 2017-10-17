package command;

public class PrintCommand implements Command{
	public void process(int[] target){
		for(int tmp : target){
			System.out.println("the elements of aimed array is: " + tmp);
		}
	}
}
