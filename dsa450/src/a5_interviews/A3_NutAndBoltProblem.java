package a5_interviews;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
 * https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. 
 * Match nuts and bolts efficiently. 
	Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
	It means nut can only be compared with bolt and bolt can only be compared with a nut to see which one is bigger/smaller.
	Examples: 
	Input : nuts[] = {'@', '#', '$', '%', '^', '&'}
	        bolts[] = {'$', '%', '&', '^', '@', '#'}
	Output : Matched nuts and bolts are-
	        $ % & ^ @ # 
	        $ % & ^ @ #  
 */
public class A3_NutAndBoltProblem {
	public static void main(String[] args) {
		char nuts[] = { '@', '#', '$', '%', '^', '&' };
	    char bolts[] = { '$', '%', '&', '^', '@', '#' };
	    int n = nuts.length;
	    HashMap<Character, Integer> hash = new HashMap<>();
	    // creating a hashmap for nuts
	    for (int i = 0; i < n; i++)
	      hash.put(nuts[i], i);
	 
	    // searching for nuts for each bolt in hash map
	    for (int i = 0; i < n; i++)
	      if (hash.containsKey(bolts[i]))
	        nuts[i] = bolts[i];
	 
	    // print the result
	    System.out.println("matched nuts and bolts are-");
	    for (int i = 0; i < n; i++)
	      System.out.print(nuts[i] + " ");
	    System.out.println();
	    for (int i = 0; i < n; i++)
	      System.out.print(bolts[i] + " ");
	}
	
	//my solution
	void matchPairs(char nuts[], char bolts[], int n) {
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,nuts[i]);
        }
        for(int i=0;i<n;i++){
            bolts[i]=map.get(i);
        }
    }
}
