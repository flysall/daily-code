import java.io.IOException;
import java.io.PrintStream;

public class WriteToProcess {
	public static void main(String[] args) throws IOException{
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try(
			PrintStream ps = new PrintStream(p.getOutputStream()))
		{
			ps.println("common aaaa string");
			ps.println(new WriteToProcess());
		}
	}
}