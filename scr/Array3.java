// Daniel Chen
// 7 October 2019
// Store 10 ints in array and print all larger than limit

import java.util.Scanner;

class Array3 {
	public static void main(String[] args) {
		int[] numArray = new int[10]; // Create empty array
		Scanner input = new Scanner(System.in); // Set up input
		
		for (int i = 0; i < numArray.length; i++) {
			System.out.print("Number " + (i + 1) + ": ");
			numArray[i] = input.nextInt();
		}
		
		// Ask for limit
		System.out.print("Limit: ");
		int limit = input.nextInt();
		
		// Output unlimited numbers only
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] > limit) {System.out.println(numArray[i]);}
		}
	}
}
