package a3_string;

/*
 * https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/
 * https://www.youtube.com/watch?v=UyX22tCpzhI
 * Given a binary string str of length N, the task is to find the maximum count of consecutive substrings str can be divided 
 * into such that all the substrings are balanced i.e. 
 * they have equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.
	Example: 
	Input: str = “0100110101” 
	Output: 4 
	The required substrings are “01”, “0011”, “01” and “01”.
 */
public class B3_SplitTheBinaryStringIntoSubstr {
	public static void main(String[] args) {
		String str = "0100110101";
		int count0 = 0;
		int count1 = 0;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				count0++;
			else
				count1++;
			if (count0 == count1)
				count++;
		}
		if (count1 != count0)
			System.out.println(-1);
		else
			System.out.println(count);
		
	}
}
