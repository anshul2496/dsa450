package arrays;

import java.util.Arrays;

public class C1_RearrangeArrayInAltPosAndNeg {

	/*
	 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
	 * 
	 * Given an array of positive and negative numbers, arrange them in an alternate
	 * fashion such that every positive number is followed by negative and
	 * vice-versa maintaining the order of appearance. Number of positive and
	 * negative numbers need not be equal. If there are more positive numbers they
	 * appear at the end of the array. If there are more negative numbers, they too
	 * appear in the end of the array.
	 * 
	 * Examples :
	 * 
	 * Input: arr[] = {1, 2, 3, -4, -1, 4} Output: arr[] = {-4, 1, -1, 2, 3, 4}
	 */
	public static void main(String[] args) {
		//solution1();
		solution2();
	}

	private static void solution2() {
		// Given array
        int[] arr = { 2, 3, -4, -1, 6, -9, -5,2 };
        int n = arr.length;
        System.out.println("Given array is  ");
        print(arr, n);
        int neg = 0, pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                neg++;
            else
                pos++;
        }
        // Sort the array
        Arrays.sort(arr);
 
        if (neg <= pos) {
            fill1(arr, neg, pos);
        }
        else {
            // reverse the array in this condition
            reverse(arr, n);
            fill2(arr, neg, pos);
        }
        System.out.println("Rearranged array is  ");
        print(arr, n);		
	}

	  // function which works in the condition when number of
    // negative numbers are lesser or equal than positive
    // numbers
    static void fill1(int a[], int neg, int pos)
    {
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int c = a[i];
                int d = a[i + neg];
                int temp = c;
                a[i] = d;
                a[i + neg] = temp;
            }
        }
        else {
            for (int i = 1; i <= neg; i += 2) {
                int c = a[i];
                int d = a[i + neg - 1];
                int temp = c;
                a[i] = d;
                a[i + neg - 1] = temp;
            }
        }
    }
   
    // Function which works in the condition when number of
    // negative numbers are greater than positive numbers
    static void fill2(int a[], int neg, int pos)
    {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                int temp = c;
                a[i] = d;
                a[i + pos] = temp;
            }
        }
        else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                int temp = c;
                a[i] = d;
                a[i + pos - 1] = temp;
            }
        }
    }
   
    // Reverse the array
    static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
   
    // Print the array
    static void print(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
	private static void solution1() {
		int[] a = { 1, 2, 3, -4, -1, 4 };
		int[] b = new int[a.length];
		int k = 0;
		int m = a.length - 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				b[k++] = a[i];
			} else {
				b[m--] = a[i];
			}
		}
		Arrays.stream(b).forEach(System.out::println);
	}

}
