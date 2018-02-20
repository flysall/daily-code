package flysall.concurrency.waxomatic2;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static net.mindview.util.Print.*;

class Car {
    private Lock lock = new ReentrantLock();
    private Condition condition  = lock.newCondition();
    /**
     * 为true表明涂蜡完成, 等待抛光
     */
    private boolean waxOn = false;

    /**
     * 该方法调用后即表示涂蜡结束
     */
    public void waxed() {
        lock.lock();
        try {
            waxOn = true;   // Ready to buff
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 调用该方法后表示抛光结束
     */
    public void buffered() {
        lock.lock();
        try {
            waxOn = false;  // Ready to wax
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 等待涂蜡完成
     * @throws InterruptedException
     */
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while(waxOn == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while(waxOn == true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) {
        car = c;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                printnb("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax on task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) {
        car = c;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                // waitForWaxing() 方法结束, 表明已经涂蜡完成
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class WaxOMatic2 {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
