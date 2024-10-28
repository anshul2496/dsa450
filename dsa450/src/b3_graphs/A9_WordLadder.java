package b3_graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * https://leetcode.com/problems/word-ladder/
 * https://www.youtube.com/watch?v=zjR2WGbBA2k
 */
public class A9_WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = Arrays.asList(arr);
		System.out.println(ladderLength(beginWord, endWord, list));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord))
			return 0;
		ArrayDeque<String> q = new ArrayDeque<>();
		q.add(beginWord);
		if (set.contains(beginWord))
			set.remove(beginWord);
		int level = 0;
		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				String top = q.removeFirst();
				if (top.equals(endWord))
					return level + 1;
				List<String> neighbors = getNeighbors(top, set);
				System.out.println("level=" + level + " Word in queue=" + top + " " + neighbors);
				for (String neighbor : neighbors) {
					if (set.contains(neighbor)) {
						q.add(neighbor);
						set.remove(neighbor);
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static List<String> getNeighbors(String word, HashSet<String> set) {
		List<String> neighbors = new ArrayList<>();
		int n = word.length();
		for (int i = 0; i < n; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch == word.charAt(i))
					continue;
				String newWord = word.substring(0, i) + ch + word.substring(i + 1, n);
				if (set.contains(newWord))
					neighbors.add(newWord);
			}
		}
		return neighbors;
	}
}
