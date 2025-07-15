 package interviews;

import java.util.ArrayList;

/*
 * https://www.youtube.com/watch?v=hMJAlbJIS7E
 * You are climbing a staircase. It takes n steps to reach the top.
   Each time you can either climb 1 or 2 or 3 steps. Get the total distinct ways you can climb to the top
 */
public class A8_GetStairsPath {
	public static void main(String[] args) {
		int n = 5;
		ArrayList<String> paths = getStairPaths(n);
		System.out.println(paths);
	}

	private static ArrayList<String> getStairPaths(int n) {
		if (n == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		} else if (n < 0) {
			ArrayList<String> list = new ArrayList<>();
			return list;
		}
		ArrayList<String> paths1 = getStairPaths(n - 1);
		ArrayList<String> paths2 = getStairPaths(n - 2);
		ArrayList<String> paths3 = getStairPaths(n - 3);

		ArrayList<String> paths = new ArrayList<>();
		for (String path : paths1) {
			paths.add(path + 1);
		}
		for (String path : paths2) {
			paths.add(path + 2);
		}
		for (String path : paths3) {
			paths.add(path + 3);
		}
		return paths;
	}

}
