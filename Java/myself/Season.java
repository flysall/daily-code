package myself;

public class Season {
	private final String name;
	private final String desc;
	public static final Season SPRING = new Season("Spring", "running");
	public static final Season SUMMER = new Season("Summer", "shining");
	public static final Season FALL = new Season("autumn", "cool");
	public static final Season WINTER = new Season("winter", "snow");
	public static Season getSeason(int seasonNum)
	{
		switch(seasonNum)
		{
		case 1:
			return SPRING;
		case 2:
			return SUMMER;
		case 3:
			return FALL;
		case 4:
			return WINTER;
		default:
			return null;
		}
	}
	private Season(String name, String desc)
	{
		this.name = name;
		this.desc = desc;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDesc()
	{
		return this.desc;
	}
}
