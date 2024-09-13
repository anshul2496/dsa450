package a8_greedy;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * https://www.youtube.com/watch?v=tUiJu5DYO1Y
 */
public class A4_FractionalKnapsack {
	public static void main(String[] args) {
		int n = 3, w = 50;
		int value[] = { 60, 100, 120 };
		int weight[] = { 10, 20, 30 };
		double ans = fractionalKnapsack(w, value, weight, n);
		System.out.println(ans);
	}

	private static double fractionalKnapsack(int w, int[] value, int[] weight, int n) {
		Item[] items = new Item[n];
		double ans = 0;
		for (int i = 0; i < n; i++) {
			Item it = new Item(value[i], weight[i], value[i] * 1.0 / weight[i]);
			items[i] = it;
		}
		Arrays.sort(items);
		int rc = w;
		for (int i = 0; i < n; i++) {
			if (items[i].weight <= rc) {
				ans += items[i].value;
				rc = rc - items[i].weight;
			} else {
				ans += items[i].ratio * rc;
				break;
			}
		}
		return ans;
	}
}

class Item implements Comparable<Item> {
	int value;
	int weight;
	double ratio;

	public Item(int value, int weight, double ratio) {
		this.value = value;
		this.weight = weight;
		this.ratio = ratio;
	}

	public int compareTo(Item other){
        if(other.ratio < this.ratio){
            return -1;
        } else if(other.ratio > this.ratio) {
            return 1;
        }
        return 0;
    }
}