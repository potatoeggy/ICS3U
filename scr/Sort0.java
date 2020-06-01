// Daniel Chen
// 16 October 2019
// Sorting and searching test

import java.util.Arrays;

class Sort0 {
	public static void main(String[] args) {
		int[] array = {3, 6, 5, 4, 2};
		int tempswap = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					tempswap = array[j - 1];
					array[j - 1] = array[j];
					array[j] = tempswap;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
