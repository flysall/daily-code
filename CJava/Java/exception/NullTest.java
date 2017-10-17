package exception;

import java.util.Date;

public class NullTest {
	public static void main(String[] args){
		Date d = null;
		try{
			System.out.println(d.after(new Date()));
		}
		catch(NullPointerException ne){
			System.out.println("the null pointer is abnormal");
		}
		catch(Exception e){
			System.out.println("unknow exception");
		}
	}
}
