package a3_string;

/*
 * https://leetcode.com/problems/longest-common-prefix/
 * https://leetcode.com/problems/longest-common-prefix/discuss/6910/Java-code-with-13-lines/8084
 * Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	Input: strs = ["flower","flow","flight"]
	Output: "fl"
 */
public class C4_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		if (strs.length == 0)
			System.out.println("None");
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (!strs[i].startsWith(pre))
				pre = pre.substring(0, pre.length() - 1);
		System.out.println(pre);
	}
}
