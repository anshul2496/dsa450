package a4_searching_sorting;

/*
 * https://www.spoj.com/problems/ANARC05B/
 * https://www.youtube.com/watch?v=w-6YHcGmSxM&t=23s
 */
public class C3_DoubleHelix {
	public static void main(String[] args) {
		int[] a = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62 };
		int[] b = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100 };
		int ans = 0;
		int i = 0;
		int j = 0;
		int s1 = 0;
		int s2 = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				s1 += a[i++];
			else if (a[i] > b[j])
				s2 += b[j++];
			else {
				ans += Math.max(s1, s2) + a[i];
				s1 = s2 = 0;
				i++;
				j++;
			}
		}
		while (i < a.length)
			s1 += a[i++];
		while (j < b.length)
			s2 += b[j++];
		ans += Math.max(s1, s2);
		System.out.println(ans);
	}
}
