package Thread;

public class ThreadGroupTest {
	public static void main(String[] args){
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("the name of threadgroup" + mainGroup.getName());
		System.out.println("Does mainGroup daemonthreadGroup: " + mainGroup.isDaemon());
		new MyThread("the thread of mainGroup").start();
		ThreadGroup tg = new ThreadGroup("new threadgroup");
		tg.setDaemon(true);
		System.out.println("is tg threadgroup daemonthreadgroup: " + tg.isDaemon());
		MyThread tt = new MyThread(tg, "tg组的线程甲");
		tt.start();
		new MyThread(tg, "tg组的线程乙").start();
	}
}
