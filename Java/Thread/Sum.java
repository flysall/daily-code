package Thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Sum {
	public static void main(String[] args) throws Exception{
		int[] arr = new int[100];
		Random rand = new Random();
		int total = 0;
		for(int i = 0, len = arr.length; i<len; i++){
			int tmp = rand.nextInt(20);
			total += (arr[i] = tmp);
		}
		System.out.println(total);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		pool.shutdown();
	}
}
