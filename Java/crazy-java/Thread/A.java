package Thread;

public class A {
	public synchronized void foo(B b){
		System.out.println("the name of current thread: " + Thread.currentThread().getName() + " entry the foo() method of A example");
		try{
			Thread.sleep(200);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("the name of current thread: " + Thread.currentThread().getName() + " try to invoke the last() method of B example");
		b.last();
	}
	public synchronized void last(){
		System.out.println("entry the inner of last() method of A Class");
	}
}

















