package a5_interviews;

import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently. 
	Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
	It means nut can only be compared with bolt and bolt can only be compared with a nut to see which one is bigger/smaller.
	Examples: 
	Input : nuts[] = {'@', '#', '$', '%', '^', '&'}
	        bolts[] = {'$', '%', '&', '^', '@', '#'}
	Output : Matched nuts and bolts are-
	        $ % & ^ @ # 
	        $ % & ^ @ #  
 */
public class A4_NutAndBoltProblemPartition {
	public static void main(String[] args) {
		char nuts[] = { '@', '#', '$', '%', '^', '&' };
		char bolts[] = { '$', '%', '&', '^', '@', '#' };
		matchPairs(nuts, bolts, 0, 5);
		System.out.println("Matched nuts and bolts are : ");
		printArray(nuts);
		printArray(bolts);
	}

	private static void printArray(char[] arr) {
		for (char ch : arr) {
			System.out.print(ch + " ");
		}
		System.out.print("\n");
	}

	// Method which works just like quick sort
	private static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
		if (low < high) {
			// Choose last character of bolts array for nuts partition.
			int pivot = partition(nuts, low, high, bolts[high]);

			// Now using the partition of nuts choose that for bolts partition.
			partition(bolts, low, high, nuts[pivot]);

			// Recur for [low...pivot-1] & [pivot+1...high] for nuts and bolts array.
			matchPairs(nuts, bolts, low, pivot - 1);
			matchPairs(nuts, bolts, pivot + 1, high);
		}
	}

	// Similar to standard partition method. Here we pass the pivot element
	// too instead of choosing it inside the method.
	private static int partition(char[] arr, int low, int high, char pivot) {
		int i = low;
		char temp1, temp2;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				temp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp1;
				i++;
			} else if (arr[j] == pivot) {
				temp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = temp1;
				j--;
			}
		}
		temp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = temp2;

		// Return the partition index of an array based on the pivot
		// element of other array.
		return i;
	}
}
