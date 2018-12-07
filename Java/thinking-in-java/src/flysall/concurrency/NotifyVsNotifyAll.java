package flysall.concurrency;

import java.util.concurrent.*;
import java.util.*;

class Blocker {
    /**
     * 使当前未处于中断状态的线程状态为wait状态
     */
    synchronized void waitingCall() {
        try {
            while(!Thread.interrupted()) {
                long current = System.currentTimeMillis();
                wait();
                System.out.println("\n\tWait time is: " + (System.currentTimeMillis() - current) + "ms");
                System.out.print("\t\t" + Thread.currentThread() + " ");
            }
        } catch(InterruptedException e) {

        }
    }

    /**
     * 调用notify()
     */
    synchronized void prod() {
        notify();
    }

    /**
     * 调用notifyAll()
     */
    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();
    public void run() {
        blocker.waitingCall();
    }
}

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Task());
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            public void run() {
                if(prod) {
                    System.out.print("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nTimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        exec.shutdownNow();
    }
}
