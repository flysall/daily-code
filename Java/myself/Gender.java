package myself;

public enum Gender implements GenderDesc{
	MALE("man"){
		public void info(){
			System.out.println("this enum class present male");
		}
	},
	FEMALE("woman"){
		public void info(){
			System.out.println("this enum class present female");
		}
	};
	private String name;
	private Gender(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
