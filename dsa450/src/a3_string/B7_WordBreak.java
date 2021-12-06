package a3_string;

import java.util.HashSet;
import java.util.Set;

/*
 * https://practice.geeksforgeeks.org/problems/word-break1352/1
 * Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words.
	Note: From the dictionary B each word can be taken any number of times and in any order.
	Example 1:
	Input:
	n = 12
	B = { "i", "like", "sam",
	"sung", "samsung", "mobile",
	"ice","cream", "icecream",
	"man", "go", "mango" }
	A = "ilike"
	Output:
	1
	Explanation:
	The string can be segmented as "i like".
 */
public class B7_WordBreak {
	public static void main(String[] args) {
		// Using Backtracking
		Set<String> set = new HashSet<>();
		set.add("i");
		set.add("like");
		set.add("sam");
		set.add("sung");
		set.add("samsung");
		set.add("mobile");
		set.add("ice");
		set.add("cream");
		set.add("icecream");
		set.add("man");
		set.add("go");
		set.add("mango");
		String str = "ilike";
		wordBreak(set, str, "");
	}

	private static void wordBreak(Set<String> set, String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i + 1);
			if (set.contains(left)) {
				String right = str.substring(i + 1);
				wordBreak(set, right, ans + left + " ");
			}
		}
	}
}
