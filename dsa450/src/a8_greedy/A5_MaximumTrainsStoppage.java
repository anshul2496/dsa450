package a8_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * https://practice.geeksforgeeks.org/problems/maximum-trains-for-which-stoppage-can-be-provided/1
 * https://www.youtube.com/watch?v=naDecrj9Cyc
 * Code is correct but all test cases not running in gfg
 */
public class A5_MaximumTrainsStoppage {
	public static void main(String[] args) {
		int n = 3; // no of platforms
		int m = 6; // no of trains
		ArrayList<ArrayList<Integer>> trains = getArrayList();
		int maxStop = getMaxStop(n, m, trains);
		System.out.println(maxStop);
	}

	private static int getMaxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
		int ans = 0;
		int[] temp = new int[n + 1];
		Collections.sort(trains, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				return a.get(1) - b.get(1);
			}
		});
		for (int i = 0; i < trains.size(); i++) {
			ArrayList<Integer> train = trains.get(i);
			int platform = train.get(2);
			int endTime = train.get(1);
			if (temp[platform] == 0) {
				temp[platform] = endTime;
				ans++;
			} else {
				if (temp[platform] < train.get(0)) {
					temp[platform] = endTime;
					ans++;
				}
			}
		}
		return ans;
	}

	private static ArrayList<ArrayList<Integer>> getArrayList() {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(getContent(1010, 1030, 1));
		list.add(getContent(1000, 1030, 1));
		list.add(getContent(1000, 1020, 2));
		list.add(getContent(1030, 1230, 2));
		list.add(getContent(1200, 1230, 3));
		list.add(getContent(900, 1005, 1));
		return list;
	}

	private static ArrayList<Integer> getContent(int i, int j, int k) {
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(i);
		temp.add(j);
		temp.add(k);
		return temp;
	}
}
