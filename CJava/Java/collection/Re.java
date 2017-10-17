package collection;

public class Re implements Comparable{
	int count;
	public Re(int count){
		this.count = count;
	}
	public String toString()
	{
		return "Re[count:" + count + "]";
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == Re.class){
			Re r = (Re)obj;
			return r.count == this.count;
		}
		return false;
	}
	public int compareTo(Object obj){
		Re r = (Re)obj;
		return count > r.count ? 1 : count < r.count ? -1 : 0;
	}
}








