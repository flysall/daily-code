package NIO;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	public static void main(String[] args) throws Exception
	{
		Files.copy(Paths.get("FilesTest.java"), new FileOutputStream("a.txt"));
		System.out.println("Is the FilesTest.java hiden?" + Files.isHidden(Paths.get("FilesTest.java")));
		List<String> lines = Files.readAllLines(Paths.get("FilesTest.java"), Charset.forName("gbk"));
		System.out.println(lines);
		System.out.println("the size of FilesTest.java is: " + Files.size(Paths.get("FilesTest.java")));
		List<String> poem = new ArrayList<>();
		poem.add("fish");
		poem.add("moon");
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("gbk"));
		Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
		Files.lines(Paths.get("FilesTest.java"), Charset.forName("gbk")).forEach(line->System.out.println(line));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C: all space: " + cStore.getTotalSpace());
		System.out.println("C: Available space: " + cStore.getUsableSpace());
		
	}
}
