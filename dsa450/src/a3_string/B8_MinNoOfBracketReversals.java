package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1
 * https://www.youtube.com/watch?v=FB6wSdPjVGw
 * Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals 
 * required to convert the string into a balanced expression.
	A reversal means changing '{' to '}' or vice-versa.
	Example 1:
	Input:
	S = "}{{}}{{{"
	Output: 3
	Explanation: One way to balance is:"{{{}}{}}". There is no balanced sequence that can be formed in lesser reversals.
 */
public class B8_MinNoOfBracketReversals {
	public static void main(String[] args) {
		String str = "}{{}}{{{";
		int rev = getReverseCounts(str);
		System.out.println(rev);
	}

	private static int getReverseCounts(String str) {
		int rev = 0;
		int open = 0;
		int close = 0;
		if ((str.length() % 2) != 0)
			return -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{')
				open++;
			else {
				if (open == 0)
					close++;
				else
					open--;
			}
		}
		rev = (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
		return rev;
	}
}
