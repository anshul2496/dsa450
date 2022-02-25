package a5_interviews;

public class A21_Base26ToDecimal {
	public static void main(String[] args) {
		String s = "AAA";
		int n = s.charAt(0)-64;
		for (int i = 1; i < s.length(); i++) {
			n = (n * 26) + (s.charAt(i) - 64);
		}
		System.out.println(n);
	}
}
