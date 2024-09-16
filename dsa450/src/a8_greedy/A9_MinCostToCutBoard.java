package a8_greedy;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1
 * https://www.youtube.com/watch?v=qv96gEKf6zY
 */
public class A9_MinCostToCutBoard {
	public static void main(String[] args) {
		int[] x = { 2, 1, 3, 1, 4 };
		int[] y = { 4, 1, 2 };
		int m = 6;
		int n = 4;
		int ans = minimumCostOfBreaking(x, y, m, n);
		System.out.println(ans);
	}

	private static int minimumCostOfBreaking(int[] x, int[] y, int m, int n) {
		int ans = 0;
		Arrays.sort(x);
		Arrays.sort(y);
		int i=x.length-1;
		int j=y.length-1;
		int vert=1;
		int hor=1;
		while(i>=0 && j>=0) {
			if(x[i]>y[j]) {
				ans+=x[i]*vert;
				hor++;
				i--;
			}else {
				ans+=y[j]*hor;
				vert++;
				j--;
			}
		}
		while(i>=0) {
			ans+=x[i]*vert;
			i--;
		}
		while(j>=0) {
			ans+=y[j]*hor;
			j--;
		}
		return ans;
	}
}
