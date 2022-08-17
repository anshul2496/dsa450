package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * https://www.youtube.com/watch?v=buOBkLADSxk
 */
public class A4_FindRepeatingAndMissing {
	public static void main(String[] args) {
		int[] a = { 2,2 };
		int[] ans = new int[2];
		int origSum = 0;
		int currSum = 0;
		for (int i = 0; i < a.length; i++) {
			int origElement = Math.abs(a[i]);
			int index = origElement - 1;
			if (a[index] < 0)
				ans[0] = origElement;
			a[index] = -a[index];
			origSum += (i + 1);
			currSum += origElement;
		}
		ans[1] = origSum - (currSum - ans[0]);
		System.out.println(Arrays.toString(ans));
	}
	
	// With O(n) space
	int[] findTwoElement(int a[], int n) {
        int[] temp=new int[n+1];
        int[] ans=new int[2];
        for(int i=0;i<n;i++){
            int num=a[i];
            if(temp[num]==-1) ans[0]=num;
            else temp[num]=-1;
        }
        for(int i=1;i<=n;i++){
            if(temp[i]==0) ans[1]=i;
        }
        return ans;
    } 
}
