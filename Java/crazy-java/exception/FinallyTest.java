package exception;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
	public static void main(String[] args){
		FileInputStream fis = null;
		try{
			fis = new FileInputStream("a.txt");
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
			//return;
			System.exit(1);
		}
		finally{
			if(fis != null){
				try{
					fis.close();
				}
				catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
			System.out.println("excuting finally block's recycle");
		}
	}
}






