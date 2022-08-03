package a1_arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 *  https://www.youtube.com/watch?v=6_-zOrJlTDo
 * 	Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times, 
 * 	i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all 
 *  the numbers less than or equal to k together, i.e. make them a contiguous subarray.
	Input : 
	arr[ ] = {2, 1, 5, 6, 3} 
	K = 3
	Output : 
	1
	Explanation:
	To bring elements 2, 1, 3 together,swap index 2 with 4 (0-based indexing),
	i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[] = {2, 1, 3, 6, 5}
 */
public class D3_MinimumSwapsRequiredKTgether {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] arr = {2, 1, 5, 6, 3};
		int k = 3;
		int fav = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++)
			if (arr[i] <= k)
				fav++;
		
		int nonFav = 0;
		for (int i = 0; i < fav; i++)
			if (arr[i] > k)
				nonFav++;
		
		int ans = nonFav;
		for (int left = 0, right = fav; right < n; left++, right++) {
			// Decrement count of previous window
			if (arr[left] > k)
				nonFav--;
			// Increment count of current window
			if (arr[right] > k)
				nonFav++;
			// Update ans if count of 'bad' is less in current window
			ans = Math.min(ans, nonFav);
		}
		System.out.println(ans);
	}
}
