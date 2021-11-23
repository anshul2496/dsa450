package a3_string;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/reverse-string/
 * Write a function that reverses a string. The input string is given as an array of characters s.
	You must do this by modifying the input array in-place with O(1) extra memory.
	Example 1:
	Input: s = ["h","e","l","l","o"]
	Output: ["o","l","l","e","h"]
 */
public class A1_ReverseAString {
	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		int low = 0;
		int high = s.length - 1;
		while (low <= high) {
			char temp = s[low];
			s[low] = s[high];
			s[high] = temp;
			low++;
			high--;
		}
		System.out.println(Arrays.toString(s));
	}
}
