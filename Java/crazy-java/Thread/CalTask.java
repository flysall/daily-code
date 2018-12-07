package Thread;

import java.util.concurrent.RecursiveTask;

public class CalTask extends RecursiveTask<Integer>{
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;
	public CalTask(int[] arr, int start, int end){
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute(){
		int sum = 0;
		if(end - start < THRESHOLD){
			for(int i = start; i < end; i++){
				sum += arr[i];
			}
			return sum;
		}
		else{
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}
}















