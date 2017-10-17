import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) throws ClassNotFoundException{
		try(
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt")))
		{
			Person p = (Person)ois.readObject();
			System.out.println("the name is: " + p.getName() + "the age is: " + p.getAge());
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}