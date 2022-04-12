package a3_string;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/print-anagrams-together/1
 * https://www.youtube.com/watch?v=NNBQik4phMI
 * Input:
	N = 5
	words[] = {act,god,cat,dog,tac}
	Output:
	act cat tac 
	god dog
 */
public class D3_PrintAnagramTogether {
	public static void main(String[] args) {
		String[] words = { "act", "god", "cat", "dog", "tac" };
		HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

		for (String str : words) {
			HashMap<Character, Integer> fmap = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
			}

			if (bmap.containsKey(fmap)) {
				ArrayList<String> list = bmap.get(fmap);
				list.add(str);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				bmap.put(fmap, list);
			}
		}
		bmap.values().stream().forEach(System.out::println);
	}
}
