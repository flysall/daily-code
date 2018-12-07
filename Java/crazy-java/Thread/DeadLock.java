package Thread;

public class DeadLock implements Runnable{
	A a = new A();
	B b = new B();
	public void init(){
		Thread.currentThread().setName("main thread");
		a.foo(b);
		System.out.println("after entry the inner of main thread");
	}
	public void run(){
		Thread.currentThread().setName("sub thread");
		b.bar(a);
		System.out.println("after entry sub thread");
	}
	public static void main(String[] args){
		DeadLock dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}
