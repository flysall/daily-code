
public class Test {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				result = Math.max(count, result);
			} else
				count = 0;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 0, 1, 1, 1 };
		int b = Test.findMaxConsecutiveOnes(a);
		System.out.println("b = " + b);
	}
}
