package myself;

public class TestTeachableProgrammer {
	public static void main(String[] args) {
		TeachableProgrammer tp = new TeachableProgrammer("Mr LI");
		tp.work();
		tp.getCallbackReference().work();
	}
}
