package Thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyExHandler implements UncaughtExceptionHandler{
	public void uncaughtException(Thread t, Throwable e){
		System.out.println(t + " thread has exception: " + e);
	}
}
