package myself;

import java.lang.ref.WeakReference;

public class TestReference {
	public static void main(String[] args)
	{
		String str = new String("Struct2");
		WeakReference wr = new WeakReference(str);
		str = null;
		System.out.println(wr.get());
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
}
