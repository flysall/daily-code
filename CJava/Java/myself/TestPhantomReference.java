package myself;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomReference {
	public static void main(String[] args) throws Exception
	{
		String str = new String("Struts2");
		ReferenceQueue rq = new ReferenceQueue();
		PhantomReference pr = new PhantomReference(str,rq);
		str = null;
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		System.out.println(rq.poll() == pr);
	}
}
