package interviews;

import java.util.Arrays;

/*
 * Asked in Millenium
 * https://algo.monster/liteproblems/88
 */
public class B6_MergeTwoSortedArrays_Variation {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int i=0;
		for(i=0;i<nums1.length;i++) {
			if(nums1[i]==0) break;
		}
		merge(nums1, i, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int indexnums1=m-1;
		int indexnums2=n-1;
		int mergedIndex=m+n-1;
		while(indexnums2>=0) {
			if(indexnums1<0 || nums1[indexnums1]<=nums2[indexnums2]) {
				nums1[mergedIndex]=nums2[indexnums2];
				indexnums2--;
			}else {
				nums1[mergedIndex]=nums1[indexnums1];
				indexnums1--;
			}
			mergedIndex--;
		}
	}
}
