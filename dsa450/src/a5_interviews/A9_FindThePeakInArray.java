package a5_interviews;

/*
 * https://leetcode.com/problems/find-peak-element/
 * https://www.youtube.com/watch?v=r7U0N2EE_l8
 * Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. 
	Example:
	Input: array[]= {5, 10, 20, 15}
	Output: 20
	The element 20 has neighbors 10 and 15, both of them are less than 20.
 */
public class A9_FindThePeakInArray {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		int n = arr.length;
		System.out.println("Index of a peak point is " + findPeak(arr, 0, n - 1));
	}

	private static int findPeak(int[] a, int low, int high) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (a[mid] < a[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	// Linear Algorithm
//	public int findPeakElement(int[] a) {
//        if(a.length==1) return 0;
//        int peak=0;
//       for(int i=0;i<a.length;i++){
//           if(i==0){
//               if(a[i]>a[i+1]){
//                   peak=i;
//                   break;
//               }
//           }else if(i==a.length-1){
//               if(a[i]>a[i-1]){
//                   peak=i;
//                   break;
//               }
//           }else{
//               if(a[i]>a[i+1] && a[i]>a[i-1]){
//                   peak=i;
//                   break;
//               }
//           }
//       }
//       return peak;
//    }
}
