package a3_string;

/*
 * https://www.programiz.com/java-programming/examples/check-valid-shuffle-of-strings
 * https://www.youtube.com/watch?v=qN_vwYtvFUM
 * we have a string array named results. It contains three strings: 1XY2, Y1X2, and Y21XX. 
 * We are checking if these three strings are valid shuffle of strings XY and 12.
 */
public class A5_ValidShuffle {
	public static void main(String[] args) {
		String first = "XY";
		String second = "12";
		String result = "1XY2";
		int l1 = first.length();
		int l2 = second.length();
		int l3 = result.length();
		if ((l1 + l2) != l3)
			System.out.println("Not valid shuffle");
		else {
			int i = 0, j = 0, k = 0;
			int flag = 0;
			while (k < l3) {
				if (i < l1 && first.charAt(i) == result.charAt(k))
					i++;
				else if (j < l2 && second.charAt(j) == result.charAt(k))
					j++;
				else {
					flag = 1;
					break;
				}
				k++;
			}
			if (i < l1 || j < l2 || flag == 1)
				System.out.println("Not valid shuffle");
			else
				System.out.println("It is valid");
		}
	}
}
