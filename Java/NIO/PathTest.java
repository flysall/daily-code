package NIO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) throws IOException{
		Path path = Paths.get(".");
		System.out.println("the path amount in path: " + path.getNameCount());
		System.out.println("the root path of path: " + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);;
		System.out.println("the root path of absolutePath: " + absolutePath.getRoot());
		System.out.println("the path amount absolutePath: " + absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));
		Path path2 = Paths.get("g:", "publish", "codes");
		System.out.println(path2);
	}
}
