package a3_string;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1
 * https://www.youtube.com/watch?v=XEDmWJ3PMTY
 * Input:
	s = V
	Output: 5
 */
public class C3_RomanToInteger {
	public static void main(String[] args) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		String s = "VI";

		int output = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				output += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				i++;
			} else {
				output += map.get(s.charAt(i));
			}
		}
		System.out.println(output);
	}
}
