package flysall.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * A task to check a resource out of pool
 */
class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    public void run() {
        try {
            T item = pool.checkOut();
            print(this + "checking out " + item);
            TimeUnit.SECONDS.sleep(1);
            print(this + "checking in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {

        }
    }

    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}

public class SemaphoreDemo {
    final static int SIZE = 25;

    public static void main(String[] args) throws Exception {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < SIZE; i++) {
           exec.execute(new CheckoutTask<Fat>(pool));
        }
        print("All CheckoutTasks created");
        List<Fat> list = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            printnb(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            public void run() {
                try {
                    // Semaphore prevents additional checkout,
                    // so call is blocked;
                    // 此线程只签出不签入, 导致信号量不够用
                    pool.checkOut();
                } catch(InterruptedException e) {
                    print("checkOut() interrupted");
                }
            }
        });

        TimeUnit.SECONDS.sleep(2);
        // Break out of blocked call
        blocked.cancel(true);
        print("Checking in objects in " + list);
        for(Fat f : list)
            pool.checkIn(f);
        for(Fat f : list)
            pool.checkIn(f);    // Second checkIn ignored
        exec.shutdown();
    }
}
