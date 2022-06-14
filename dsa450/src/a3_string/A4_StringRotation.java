package a3_string;

/*
 * https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1? 
	(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
public class A4_StringRotation {
	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 = "CDAB";
		boolean isRotation = ((str1.length() == str2.length()) && (((str1 + str1).indexOf(str2)) != -1));
		System.out.println(isRotation);
	}
}
