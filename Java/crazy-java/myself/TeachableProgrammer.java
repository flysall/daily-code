package myself;

public class TeachableProgrammer extends Programmer {
	public TeachableProgrammer() {
	};

	public TeachableProgrammer(String name) {
		super(name);
	}

	private void teach() {
		System.out.println(getName() + "teacher is teaching...");
	}

	private class Closure implements Teachable {
		public void work() {
			teach();
		}
	}

	public Teachable getCallbackReference() {
		return new Closure();
	}
}
