package scanner;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
	public static void main(String[] args) throws Exception
	{
		Map<String, String> env = System.getenv();
		for(String name : env.keySet())
		{
			System.out.println(name + "--->  " + env.get(name));
			System.out.println(System.getenv("JAVA_HOME"));
			Properties  props = System.getProperties();
			System.out.println(System.getProperty("os.name"));
			props.store(new FileOutputStream("props.txt"), "System Properties");
		}
	}
}
