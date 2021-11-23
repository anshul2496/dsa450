package a3_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 * print all the duplicates and their counts in the input string 
 * Let input string be “geeksforgeeks” 
 */
public class A3_FindDupsInString {
	public static void main(String[] args) {
		/*
		 * Time Complexity: O(N log N), where N = length of the string passed and it
		 * generally takes logN time for an element insertion in a map. Space
		 * Complexity: O(K), where K = size of the map (0<=K<=input_string_length).
		 * 
		 * For O(N) time complexity Create an array of size  256 and fill count of
		 * every character in it int count[] = new int[NO_OF_CHARS];
		 */
		String s = "geeksforgeeks";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else
				map.put(ch, 1);
		}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}
}
