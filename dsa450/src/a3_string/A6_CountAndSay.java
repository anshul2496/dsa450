package a3_string;

/*
 * https://leetcode.com/problems/count-and-say/
 * https://www.youtube.com/watch?v=1YUqtoT9YoE
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
	countAndSay(1) = "1"
	countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
	At the beginning, I got confusions about what is the nth sequence. Well, my solution is accepted now, so I'm going to give some examples of nth sequence here. 
	The following are sequence from n=1 to n=10:
	 1.     1
	 2.     11
	 3.     21
	 4.     1211
	 5.     111221 
	 6.     312211
	 7.     13112221
	 8.     1113213211
	 9.     31131211131221
	 10.   13211311123113112211
	From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!
 */
public class A6_CountAndSay {
	public static void main(String[] args) {
		String s = countAndSay(5);
		System.out.println(s);
	}

	private static String countAndSay(int n) {
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		String s = "11";
		for (int i = 3; i <= n; i++) {
			String t = "";
			s = s + '&';
			int c = 1;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) != s.charAt(j - 1)) {
					t = t + String.valueOf(c);
					t = t + s.charAt(j - 1);
					c = 1;
				} else {
					c++;
				}
			}
			s = t;
		}
		return s;
	}
}
