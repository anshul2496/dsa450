package b3_graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/word-ladder/
 * https://www.youtube.com/watch?v=tRPda0rcf8E
 */
class Pair2 {
	String first;
	int second;

	Pair2(String first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class A9_WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = Arrays.asList(arr);
		System.out.println(ladderLength(beginWord, endWord, list));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// Time - arr.length*word.length*26
		// Space - O(arr.length)
		Queue<Pair2> q = new LinkedList<>();
		q.add(new Pair2(beginWord, 1));
		HashSet<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord))
			return 0;
		if (set.contains(beginWord))
			set.remove(beginWord);
		while (!q.isEmpty()) {
			String word = q.peek().first;
			int steps = q.peek().second;
			q.remove();
			if (word.equals(endWord))
				return steps;
			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] replacedCharArr = word.toCharArray();
					replacedCharArr[i] = ch;
					String replacedWord = new String(replacedCharArr);
					if (set.contains(replacedWord)) {
						set.remove(replacedWord);
						q.add(new Pair2(replacedWord, steps + 1));
					}
				}
			}
		}
		return 0;
	}
}
