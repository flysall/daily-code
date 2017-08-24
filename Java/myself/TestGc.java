package myself;

public class TestGc {
	public static void main(String[] args)
	{
		for(int i = 0; i<4; i++)
		{
			new TestGc();
			//System.gc();
			Runtime.getRuntime().gc();
		}
	}
	public void finalize()
	{
		System.out.println("os is cleaning the barbage of TestGc object...");
	}
}
