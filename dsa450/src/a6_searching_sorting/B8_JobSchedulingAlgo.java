package a6_searching_sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/
 * Problem - https://www.youtube.com/watch?v=CgLpOeRA6Co
 * Solution - https://www.youtube.com/watch?v=Iw8XtK1HCCw
 */
public class B8_JobSchedulingAlgo {
	public static void main(String[] args) {
		Job jobs[] = { new Job(1, 2, 50), new Job(3, 5, 20), new Job(6, 19, 100), new Job(2, 100, 200) };
		System.out.println("Optimal profit is " + schedule(jobs));
	}

	private static int schedule(Job[] jobs) {
		int[] dp = new int[jobs.length];
		Arrays.sort(jobs, new JobComparator());
		dp[0] = jobs[0].profit;
		for (int i = 1; i < jobs.length; i++) {
			int lnconflict = -1;
			int including = jobs[i].profit;
			for (int j = i - 1; j >= 0; j--) {
				if (jobs[j].finish <= jobs[i].start) {
					lnconflict = j;
					break;
				}
			}
			if (lnconflict != -1)
				including += dp[lnconflict];
			dp[i] = Math.max(including, dp[i - 1]);
		}
		return dp[dp.length - 1];
	}
}

class Job {
	int start, finish, profit;

	public Job(int start, int finish, int profit) {
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
}

class JobComparator implements Comparator<Job> {

	@Override
	public int compare(Job j1, Job j2) {
		return j1.finish < j2.finish ? -1 : j1.finish == j2.finish ? 0 : 1;
	}

}