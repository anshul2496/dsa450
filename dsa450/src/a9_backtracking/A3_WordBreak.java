package a9_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Same as Strings - B7
 * https://www.geeksforgeeks.org/problems/word-break-part-23249/1
 * https://www.youtube.com/watch?v=LmHWIsBQBU4
 */
public class A3_WordBreak {
	public static void main(String[] args) {
		String[] dicto = { "cats", "cat", "and", "sand", "dog" };
		String s = "catsanddog";
		List<String> ans = wordBreak(5, Arrays.asList(dicto), s);
		System.out.println(ans);
	}

	static List<String> wordBreak(int n, List<String> dict, String s) {
		List<String> list = new ArrayList<>();
		solve(dict, s, list, "");
		return list;
	}

	public static void solve(List<String> dict, String s, List<String> list, String ans) {
		if (s.length() == 0) {
			list.add(ans.trim());
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			if (dict.contains(left)) {
				String right = s.substring(i + 1);
				solve(dict, right, list, ans + left + " ");
			}
		}
	}
}
