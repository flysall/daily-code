import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException{
		try(RandomAccessFile raf = new RandomAccessFile("RandomAccessFileTest.java", "r"))
		{
			System.out.println("the inital position of pointer in the File: " + raf.getFilePointer());
			raf.seek(300);
			byte[] bbuf = new byte[30];
			int hasRead = 0;
			while((hasRead = raf.read(bbuf)) > 0){
				System.out.println(new String(bbuf, 0, hasRead));
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}	
