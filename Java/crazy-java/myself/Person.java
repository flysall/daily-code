package myself;

public class Person {
	private String name;
	private String idStr;

	public Person() {
	}

	public Person(String name, String idStr) {
		this.name = name;
		this.idStr = idStr;
	}

	public String getIdsr() {
		return this.idStr;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			Person personObj = (Person) obj;
			if (this.getIdsr().equals(personObj.getIdsr()));
			{
				return true;
			}
		}
		return false;
	}
}
