package a1_arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/palindromic-array-1587115620/1
 * 	Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.
 * 	Input:
 * 	5	
	111 222 333 444 555
	Output:
	1
	Explanation:
	For First test case.
	n=5;
	A[0] = 111    //which is a palindrome number.
	A[1] = 222   //which is a palindrome number.
	A[2] = 333   //which is a palindrome number.
	A[3] = 444  //which is a palindrome number.
	A[4] = 555  //which is a palindrome number.
	As all numbers are palindrome so This will return 1.
 */
public class D7_PalindromeArray {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 111, 222, 333, 444, 555 };
		boolean isPalin = true;
		for (int i = 0; i < a.length; i++) {
			String num = String.valueOf(a[i]);
			int low = 0;
			int high = num.length() - 1;
			while (low < high) {
				if (num.charAt(low) == num.charAt(high)) {
					low++;
					high--;
				} else {
					isPalin = false;
					break;
				}
			}
			if (!isPalin) {
				System.out.println(0);
				break;
			}
		}
		if (isPalin)
			System.out.println(1);
	}
}
