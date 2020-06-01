// Daniel Chen
// 17 October 2019
// Sort user-input numbers

import java.util.Scanner;
import java.util.Arrays;

class Sort1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int list[] = new int[5]; // setup array
		
		for (int i = 0; i < 5; i++) { // setup standard input
			System.out.print("Number: ");
			list[i] = input.nextInt();
		}
		
		System.out.println("Numbers: "); // output unsorted array
		System.out.println(Arrays.toString(list));
		
		int tempswap = 0; // bubble sort template for future
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < list.length - i; j++) {
				if (list[j - 1] > list[j]) {
					tempswap = list[j - 1];
					list[j - 1] = list[j];
					list[j] = tempswap;
				}
			}
		}
		
		System.out.println("Sorted Numbers: "); // output sorted array
		System.out.println(Arrays.toString(list));
	}
}
