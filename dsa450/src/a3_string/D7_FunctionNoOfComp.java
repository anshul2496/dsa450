package a3_string;

import java.util.HashMap;

/*
 *	https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 *	Write a function “runCustomerSimulation” that takes following two inputs 
	a) An integer ‘n’: total number of computers in a cafe and a string: 
	b) A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs. The first occurrence indicates the arrival of a customer; 
	the second indicates the departure of that same customer. 
	A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times. 
	Customers who leave without using a computer always depart before customers who are currently using the computers. 
	There are at most 20 computers per cafe.
	For each set of input the function should output a number telling how many customers, if any walked away without using a computer. 
	Return 0 if all the customers were able to use a computer.
	runCustomerSimulation (2, “ABBAJJKZKZ”) should return 0
	runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1 as ‘D’ was not able to get any computer
 */
public class D7_FunctionNoOfComp {
	public static void main(String[] args) {
		int n = 3;
		String str = "GACCBDDBAGEE";
		System.out.println(runCustomerSimulation(n, str));
	}

	private static int runCustomerSimulation(int n, String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch))
				map.remove(ch);
			else {
				if (map.size() < n) {
					map.put(ch, 1);
				} else {
					ans++;
					i++;
				}
			}
		}
		return ans;
	}
}
