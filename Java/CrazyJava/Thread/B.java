package Thread;

public class B {
	public synchronized void bar(A a){
		System.out.println("the name of current thread: " + Thread.currentThread() + " entry the bar() method of B example");
		try{
			Thread.sleep(200);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("the name of current thread: " + Thread.currentThread() + " try to invoke the last() method of A example");
		a.last();
	}
	public synchronized void last(){
		System.out.println("entry the inner of last() method of B Class");
	}
}
