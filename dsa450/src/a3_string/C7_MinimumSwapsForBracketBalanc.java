package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1
 * https://www.youtube.com/watch?v=WhMbbnHZpis
 * Input  : []][][
	Output : 2
	Explanation :
	First swap: Position 3 and 4
	[][]][
	Second swap: Position 5 and 6
	[][][]
 */
public class C7_MinimumSwapsForBracketBalanc {
	public static void main(String[] args) {
		String s = "[]][][";
		int open = 0;
		int close = 0;
		int swap = 0;
		int imbalance = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				open++;
				if (imbalance > 0) {
					swap += imbalance; //No of swaps required = No of imbalance brackets 
					imbalance--; // After swapping imbalance should get reduced by one
				}
			} else {
				close++;
				imbalance = close - open; //Extra close brackets are imbalanced.
			}
		}
		System.out.println(swap);
	}
}
