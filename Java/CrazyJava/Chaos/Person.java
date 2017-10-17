
public class Person {
	private final Name name;

	public Person(Name name) {
		this.name = new Name(name.getFirstName(), name.getLastName());
	}

	public Name getName() {
		return name;
	}

	public static void main(String[] args) {
		Name n = new Name("Monkey", "Mrs sun");
		Person p = new Person(n);
		System.out.println(p.getName().getFirstName());
		n.setFirstName("pig");
		System.out.println(p.getName().getFirstName());
	}
}
