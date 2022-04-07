package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1
 * https://www.youtube.com/watch?v=7b2ShX5YMXY
 * Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, 
 * our goal is to minimize the number of bits to be flipped.
	Input:
	S = "001"
	Output: 1
	Explanation: 
	We can flip the 0th bit to 1 to have 101.
 */
public class C5_MinimumNumOfFlips {
	public static void main(String[] args) {
		String s = "001";
		int flips = 0;
		// idea is to calculate string flips when the string starts from 1 and then use (length - calculated) to get the flips when the string starts from 0
		// finally return the minimum
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				// If there is a 0 at even index then we need to flip it
				if (s.charAt(i) == '0')
					flips++;
			} else {
				// If there is a 1 at odd index then we need to flip it
				if (s.charAt(i) == '1')
					flips++;
			}
		}
		// minmum flips would either be the flips in making string start with 1 or with 0
		int ans = Math.min(flips, s.length() - flips);
		System.out.println(ans);
	}
}
