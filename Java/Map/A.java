package Map;

public class A {
	int count;

	public A(int count) {
		this.count = count;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != this && obj.getClass() == A.class) {
			A a = (A) obj;
			return this.count == a.count;
		}
		return false;
	}

	public int hashCode() {
		return this.count;
	}
}
