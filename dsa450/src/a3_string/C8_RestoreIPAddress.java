package a3_string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/program-generate-possible-valid-ip-addresses-given-string/
 * https://www.youtube.com/watch?v=qu4W3idglP4
 * Input: 25525511135
	Output: [“255.255.11.135”, “255.255.111.35”]
	Explanation: These are the only valid possible IP addresses.
 */
public class C8_RestoreIPAddress {
	public static void main(String[] args) {
		String s = "11211";
		List<String> res = new ArrayList<>();
		helper(s, 0, 0, "", res);
		System.out.println(res);
	}

	private static void helper(String s, int i, int par, String ans, List<String> res) {
		if (i == s.length() || par == 4) {
			if (i == s.length() && par == 4) {
				res.add(ans.substring(0, ans.length() - 1)); // To remove the extra dot at end
			}
			return;
		}
		helper(s, i + 1, par + 1, ans + s.charAt(i) + ".", res);
		
		if (i + 2 <= s.length() && isValid(s.substring(i, i + 2))) {
			helper(s, i + 2, par + 1, ans + s.substring(i, i + 2) + ".", res);
		}
		if (i + 3 <= s.length() && isValid(s.substring(i, i + 3))) {
			helper(s, i + 3, par + 1, ans + s.substring(i, i + 3) + ".", res);
		}
	}

	private static boolean isValid(String str) {
		if (str.charAt(0) == '0')
			return false;
		int val = Integer.parseInt(str);
		return val <= 255;
	}
}
