package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
 * Given a string S, check if it is palindrome or not.
	Example 1:
	Input: S = "abba"
	Output: 1
	Explanation: S is a palindrome
 */
public class A2_StringPalindrome {
	public static void main(String[] args) {
		String s = "abccba";
		int low = 0;
		int high = s.length() - 1;
		int flag = 0;
		while (low <= high) {
			if (s.charAt(low) != s.charAt(high)) {
				flag = 1;
				break;
			}
			low++;
			high--;
		}
		if (flag == 1)
			System.out.println("Not palin");
		else
			System.out.println("palin");
	}
}
