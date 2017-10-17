package myself;

public class TestSeason {
	public TestSeason(Season s)
	{
		System.out.println(s.getName() + ", it's really a " + s.getDesc() + " season");
	}
	public static void main(String[] args)
	{
		new TestSeason(Season.FALL);
	}
}
