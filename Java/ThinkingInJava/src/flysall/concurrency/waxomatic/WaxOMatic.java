package flysall.concurrency.waxomatic;

import java.util.concurrent.*;
import static net.mindview.util.Print.*;

class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;   // Ready to buff
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false;  // Ready for another coat of wax
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false)
            wait();
    }
    public synchronized void waitBuffing() throws InterruptedException {
        while(waxOn == true)
            wait();
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
                printnb("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitBuffing();
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
                printnb("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.MILLISECONDS.sleep(4980);
        exec.shutdownNow();
    }
}
