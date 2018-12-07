package lee;

public class Printer implements Output, Product {
	private String[] printData = new String[MAX_CACHE_LINE];
	private int dataNum = 0;

	public void out() {
		while (dataNum > 0) {
			System.out.println("Printing " + printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	public void getData(String msg) {
		if (dataNum >= MAX_CACHE_LINE) {
			System.out.println("The queue is full, add is failure");
		} else {
			printData[dataNum++] = msg;
		}
	}

	public int getProduceTime() {
		return 45;
	}

	public static void main(String[] args) {
		Output o = new Printer();
		o.getData("JEE");
		o.getData("Struts");
		o.out();
		o.getData("JEE & Ajax");
		o.getData("Ruby on Rails");
		o.out();
		Product p = new Printer();
		System.out.println(p.getProduceTime());
		Object obj = p;
	}
}
