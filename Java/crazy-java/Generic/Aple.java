package Generic;

public class Aple <T extends Number>{
	T size;
	public Aple(){}
	public Aple(T size){
		this.size = size;
	}
	public T getSize(){
		return this.size;
	}
}
