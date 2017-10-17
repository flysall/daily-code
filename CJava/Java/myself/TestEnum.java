package myself;

public class TestEnum {
	public void judge(SeasonEnum s) {
		switch (s) {
		case SPRING:
			System.out.println("spring is spring");
			break;
		case SUMMER:
			System.out.println("summer is summer");
			break;
		case FALL:
			System.out.println("fall is fall");
			break;
		case WINTER:
			System.out.println("winter is winter");
			break;
		}
	}

	public static void main(String[] args) {
		for (SeasonEnum s : SeasonEnum.values()) {
			System.out.println(s);
		}
		new TestEnum().judge(SeasonEnum.SUMMER);
	}
}
