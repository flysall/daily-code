package myself;

public class Programmer {
	private String name;

	public Programmer() {
	}

	public Programmer(String name) {
		this.name = name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void work() {
		System.out.println(name + " works with keyboard in the light...");
	}
}
