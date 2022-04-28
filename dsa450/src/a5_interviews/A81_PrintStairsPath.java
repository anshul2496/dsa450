package a5_interviews;

/*
 * https://www.youtube.com/watch?v=NEuYcztalew&t=2s
 * You are climbing a staircase. It takes n steps to reach the top.
   Each time you can either climb 1 or 2 or 3 steps. Print the total distinct ways you can climb to the top
 */
public class A81_PrintStairsPath {
	public static void main(String[] args) {
		int n = 5;
		printStairPaths(n, "");
	}

	private static void printStairPaths(int n, String ans) {
		if (n < 0) {
			return;
		}
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		printStairPaths(n - 1, ans + "1");
		printStairPaths(n - 2, ans + "2");
		printStairPaths(n - 3, ans + "3");
	}
}
