package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1
 * https://www.youtube.com/watch?v=utn2wJ7VAns
 * Input:
	S = aabaa
	Output:  aba
	Explanation: 'a' at 2nd position is appearing 2nd time consecutively. 'a' at fifth position is appearing 2nd time consecutively.
 */
public class D5_RecursivelyRemoveAdjDups {
	public static void main(String[] args) {
		String s = "aabaa";
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				continue;
			} else {
				res += s.charAt(i);
			}
		}
		System.out.println(res);
	}
}
