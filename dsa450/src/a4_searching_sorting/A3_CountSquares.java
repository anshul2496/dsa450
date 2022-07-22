package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/count-squares3649/1 
 * O(sqrt(N))
 */
public class A3_CountSquares {
	public static void main(String[] args) {
		int n = 9;
		int i = 1;
		for (i = 1; (i * i) < n; i++);
		System.out.println(i-1);
	}
}
