package a9_backtracking;

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1
 * https://www.youtube.com/watch?v=wvaYrOp94k0
 */
public class A7_PalindromicPartitions {
	public static void main(String[] args) {
		System.out.println(allPalindromicPerms("geeks"));
	}

	static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		solve(s, "", ans);
		return ans;
	}

	static void solve(String s, String asf, ArrayList<ArrayList<String>> ans) {
		if (s.length() == 0) {
			ArrayList<String> temp = new ArrayList<>();
			String[] arr = asf.split(" ");
			Collections.addAll(temp, arr);
			ans.add(temp);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i + 1);
			String ros = s.substring(i + 1);
			if (isPalin(prefix)) {
				solve(ros, asf + prefix + " ", ans);
			}
		}
	}

	static boolean isPalin(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
