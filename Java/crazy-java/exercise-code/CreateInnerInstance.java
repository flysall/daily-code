
public class CreateInnerInstance {
	public static void main(String[] args)
	{
		Out.In inn = new Out().new In("TestInformation");
		Out.In in;
		Out out = new Out();
		in = out.new In("TestInformation");
	}
}
