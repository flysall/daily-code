package Thread;

import java.util.Date;

public class SleepTest {
	public static void main(String[] args) throws Exception{
		for(int i = 0; i < 10; i++){
			System.out.println("the current time: " + new Date());
			Thread.sleep(5000);
		}
	}
}
