package Thread;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + " the variable of thread i " + i);
		}
	}
}
