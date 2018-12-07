
public abstract class Shape {
	{
		System.out.println("the initialize block of executing Shape...");
	}
	private String color;

	public abstract double calPerimeter();

	public abstract String getType();

	public Shape() {
	}

	public Shape(String color) {
		System.out.println("the constructor of executing Shape...");
		this.color = color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
}
