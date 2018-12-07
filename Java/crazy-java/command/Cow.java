package command;

public class Cow {
	private double weight;

	public Cow() {
	}

	public Cow(double weight) {
		this.weight = weight;
	}

	private class CowLeg {
		private double length;
		private String color;

		public CowLeg() {
		}

		public CowLeg(double length, String color) {
			this.length = length;
			this.color = color;
		}

		public void setLength(double length) {
			this.length = length;
		}

		public double getLength() {
			return this.length;
		}

		public void setcColor(String color) {
			this.color = color;
		}

		public String getColor() {
			return this.color;
		}

		public void info() {
			System.out.println("the color of ox'sleg is: " + color + ", height is: " + length);
			System.out.println("the weight of ox is: " + weight);
		}
	}

	public void test() {
		CowLeg cl = new CowLeg(1.12, "white and black");
		cl.info();
	}

	public static void main(String[] args) {
		Cow cow = new Cow(378.9);
		cow.test();
	}
}
