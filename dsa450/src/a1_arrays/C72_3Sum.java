package a1_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * https://www.youtube.com/watch?v=1IBgYGJqKP8
 */
public class C72_3Sum {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> ans = threeSum(nums);
		System.out.println(ans);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i <= n - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int val1 = nums[i];
			int target = 0 - val1;
			List<List<Integer>> temp = twoSum(nums, i + 1, n - 1, target);
			for (List<Integer> list : temp) {
				list.add(val1);
				ans.add(list);
			}
		}
		return ans;
	}

	public static List<List<Integer>> twoSum(int[] nums, int si, int ei, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		int start = si;
		int end = ei;
		while (start < end) {
			if (start != si && nums[start] == nums[start - 1]) {
				start++;
				continue;
			}
			int sum = nums[start] + nums[end];
			if (sum == target) {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[start]);
				temp.add(nums[end]);
				ans.add(temp);
				start++;
				end--;
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		return ans;
	}
}
