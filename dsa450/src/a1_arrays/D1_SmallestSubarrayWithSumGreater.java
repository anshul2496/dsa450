package a1_arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 * 	https://www.youtube.com/watch?v=GLpB03voaCs
 * 	Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
	Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
	Input:
	A[] = {1, 4, 45, 6, 0, 19}
	x  =  51
	Output: 3
	Minimum length subarray is {4, 45, 6}
 */
public class D1_SmallestSubarrayWithSumGreater {
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		int[] a = { 1, 4, 45, 6, 0, 19 };
		int x = 51;
		int n = a.length;
		int ans = Integer.MAX_VALUE;
		int start = 0;
		int end = 1;
		int sum = a[start];
		if (sum > x)
			System.out.println(1);
		if (end < n)
			sum += a[end];

		while (start < n && end < n) {
			if (sum > x) {
				ans = Math.min(ans, end - start + 1);
				sum -= a[start];
				start++;
			} else {
				end++;
				if (end < n) {
					sum += a[end];
				}
			}
		}
		System.out.println(ans);
	}

	// My code after studying
	public static int smallestSubWithSum(int a[], int n, int x) {
        int ans=Integer.MAX_VALUE;
        int j=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            while(sum>x){
                ans=Math.min(ans,i-j+1);
                sum=sum-a[j++];
            }
        }
        return ans;
    }
	
	private static void solution1() {
		int[] a = { 1, 4, 45, 6, 0, 19 };
		int x = 51;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				if (sum > x) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				}
			}
		}
		System.out.println(minLength);
	}
}
