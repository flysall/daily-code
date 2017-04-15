import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args){
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt")))
		{
			Person per = new Person("monkey", 500);
			oos.writeObject(per);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
