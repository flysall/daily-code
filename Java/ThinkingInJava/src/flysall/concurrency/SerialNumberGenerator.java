package flysall.concurrency;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    /**
     * 返回自增值
     * @return
     */
    public static int nextSerialNumber() {
        return serialNumber++;  //Not thread-safe
    }
}
