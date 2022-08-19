package a4_searching_sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 * https://www.youtube.com/watch?v=LjPx4wQaRIs
 */
public class B71_JobScheduling {
	public static void main(String[] args) {
		Jobs[] a = { new Jobs(1, 4, 20), new Jobs(2, 1, 10), new Jobs(3, 1, 40), new Jobs(4, 1, 30) };
		Arrays.sort(a, new Comparator<Jobs>() {
			@Override
			public int compare(Jobs o1, Jobs o2) {
				return o2.profit - o1.profit; // return Integer.compare(b.profit,a.profit);
			}
		});
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i].deadline);
		}
		int[] result = new int[max + 1];
		int count = 0;
		int profit = 0;
		for (int i = 1; i < a.length; i++)
			result[i] = -1;
		for (int i = 0; i < a.length; i++) {
			for (int j = a[i].deadline; j >= 1; j--) {
				if (result[j] == -1) {
					result[j] = a[i].id;
					count++;
					profit += a[i].profit;
					break;
				}
			}
		}
		System.out.println(count + " " + profit);
	}
}

class Jobs {
	int id, deadline, profit;

	public Jobs(int id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}