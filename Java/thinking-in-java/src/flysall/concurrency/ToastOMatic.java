package flysall.concurrency;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Toast {
    public enum Status {
        DRY, BUTTERED, JAMMED
    }

    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn) {
        id = idn;
    }
    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                // Make toast
                Toast t = new Toast(count++);
                print(t);
                toastQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}

/**
 * Apply butter to toast
 */
class Butter implements Runnable {
    private ToastQueue dryQueue, butterQueue;;

    public Butter(ToastQueue dryQueue, ToastQueue butterQueue) {
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = dryQueue.take();
                t.butter();
                print(t);
                butterQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("Butter interruted");
        }
        print("Butter off");
    }
}

/**
 * Apply jam to buttered toast
 */
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available
                Toast t = butteredQueue.take();
                t.jam();
                print(t);
                finishedQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}

/**
 * Consume the toast:
 */
class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                // Verify that toast is coming in order and they
                // are all getting jammed.
                if(t.getId() != counter++ ||
                        t.getStatus() != Toast.Status.JAMMED) {
                    print(">>>Error: " + t);
                    System.exit(1);
                } else {
                    print("Chomp! " + t);
                }
            }
        } catch(InterruptedException e) {
            print("Eater interrupted");
        }
        print("Eater off");
    }
}

public class ToastOMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butter(dryQueue, butterQueue));
        exec.execute(new Jammer(butterQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
