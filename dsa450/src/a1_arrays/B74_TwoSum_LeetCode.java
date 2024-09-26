package a1_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/description/
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
 */
public class B74_TwoSum_LeetCode {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int[] ans = twoSum(nums, 9);
		Arrays.stream(ans).forEach(System.out::println);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		int rem = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			rem = target - nums[i];
			if (map.containsKey(rem)) {
				ans[0] = map.get(rem);
				ans[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return ans;
	}
}
