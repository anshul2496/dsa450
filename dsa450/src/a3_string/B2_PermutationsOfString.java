package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 * Given a string S. The task is to print all permutations of a given string in lexicographically sorted order.
	Example 1:
	Input: ABC
	Output:
	ABC ACB BAC BCA CAB CBA
	Explanation:
	Given string ABC has permutations in 6 
	forms as ABC, ACB, BAC, BCA, CAB and CBA .
 */
public class B2_PermutationsOfString {
	public static void main(String[] args) {
		String str = "abc";
		printPermutation(str, "");
	}

	private static void printPermutation(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String leftPart = str.substring(0, i);
			String rightPart = str.substring(i + 1);
			String restOfString = leftPart + rightPart;
			printPermutation(restOfString, ans + ch);
		}
	}
}
