package Annotation;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import javax.swing.JFrame;

@NotNull
public class TypeAnnotationTest implements @NotNull Serializable{
	public static void main(@NotNull String[] args) throws @NotNull FileNotFoundException{
		Object obj = "fkjava.org";
		String str = (@NotNull String)obj;
		Object win = new @NotNull JFrame("crazy");
	}
	public void foo(List<@NotNull String> info){}
}
