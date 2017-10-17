package myself;

import java.util.Scanner;

public class ScannerKeyBoardTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong())
		{
			System.out.println("the keyboard is: " + sc.nextLong());
		}
	}
}
