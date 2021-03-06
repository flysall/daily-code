//package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
	public static void  main(String[] args){
		try(
			FileInputStream fis = new FileInputStream("RedirectIn.java"))
		{
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				System.out.println("the contents of keyboard are: " + sc.next());
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}