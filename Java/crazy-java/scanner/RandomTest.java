package scanner;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("rand.nextBoolean(): " + rand.nextBoolean());
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		System.out.println("rand.nextDouble(): " + rand.nextDouble());
		System.out.println("rand.nextFloat(): " + rand.nextFloat());
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		System.out.println("rand.nextInt(): " + rand.nextInt());
		System.out.println("rand.nextInt(26): " + rand.nextInt(26));
		Random randsr = new Random(System.currentTimeMillis());
		System.out.println(randsr);
	}
}
