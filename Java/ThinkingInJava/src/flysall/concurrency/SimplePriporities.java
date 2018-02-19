package flysall.concurrency;

import java.util.concurrent.*;

public class SimplePriporities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriporities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true) {
            // An expensive, inerruptable operation:
            for(int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new SimplePriporities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriporities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
