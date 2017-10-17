package scanner;

import java.io.File;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("ScannerFileTest.java"));
		System.out.println("ScannerFileTest is :  ");
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
	}
}
