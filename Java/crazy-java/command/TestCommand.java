package command;

public class TestCommand {

	public static void main(String[] args) {
		ProcessArray pa = new ProcessArray();
		int[] target = { 3, -4, 6, 4 };
		pa.pprocess(target, new PrintCommand());
		System.out.println("------------------");
		pa.pprocess(target, new AddCommand());
	}
}
