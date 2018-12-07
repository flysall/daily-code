package flysall.concurrency;

import static net.mindview.util.Print.*;

public class ThreadLocalExample {
/*
    public static class MyRunnable implements Runnable {
        private int unsharedVal = 1;
        private double sharedVal = 1.0;
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set(unsharedVal);
            int tmpVal = threadLocal.get();
            for (int i = 0; i < 1000; i++) {
                tmpVal++;
                sharedVal++;
            }
            threadLocal.set(tmpVal);
            print(Thread.currentThread().getName() + " unsharedVal is: " + threadLocal.get());
            print(Thread.currentThread().getName() + " sharedVal is: " + sharedVal);
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance, "thread1");
        Thread thread2 = new Thread(sharedRunnableInstance, "thread2");
        thread1.start();
        thread2.start();
    }
*/
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static int value = 0;
    public static class ThreadLocalThread implements Runnable {
        @Override
        public void run() {
            threadLocal.set((int)(Math.random() * 100));
            threadLocal.set((int)(Math.random() * 100));
            value = (int) (Math.random() * 100);
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(Thread.currentThread().getName() + ": threadLocal=%d, value=%d\n", threadLocal.get(), value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadLocalThread(), "t1");
        Thread thread2 = new Thread(new ThreadLocalThread(), "t2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
