package myself;

public class TestFinalize {
	private static TestFinalize tf = null;

	public void info() {
		System.out.println("the finalize method of testing garbage clean");
	}

	public static void main(String[] args) throws Exception {
		new TestFinalize();
		System.gc();
		Runtime.getRuntime().runFinalization();
		tf.info();
	}

	public void finalize() {
		tf = this;
	}
}
