// Daniel Chen
// 17 October 2019
// Sort user-input numbers in descending order

import java.util.Scanner;
import java.util.Arrays;

class Sort1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int list[] = new int[5]; // setup array
		
		for (int i = 0; i < 5; i++) { // ask for input
			System.out.print("Number: ");
			list[i] = input.nextInt();
		}
		
		System.out.println("Numbers: ");
		System.out.println(Arrays.toString(list)); // print unsorted array
		
		int tempswap = 0; // copy-pasted template for bubble sort
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < list.length - i; j++) {
				if (list[j - 1] > list[j]) { // changed so that it sorts in descending order
					tempswap = list[j - 1];
					list[j - 1] = list[j];
					list[j] = tempswap;
				}
			}
		}
		
		System.out.println("Sorted Numbers: ");
		System.out.println(Arrays.toString(list)); // print sorted array
	}
}
