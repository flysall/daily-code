package flysall.concurrency;

import java.util.concurrent.*;

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for(int i = 0; i < size; i++)
            array[i] = -1;
    }

    /**
     * 将当前的index位置赋值为i, index增1
     * @param i
     */
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    /**
     * 判断是否包含val
     * @param val
     * @return
     */
    public synchronized boolean contains(int val) {
        for(int i = 0; i < len; i++)
            if(array[i] == val)
                return true;
        return false;
    }
}

public class SerialNumberCheckeer {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {
        public void run() {
            while(true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if(args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}
