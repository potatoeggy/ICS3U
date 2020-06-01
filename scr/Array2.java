// Daniel Chen
// 7 October 2019
// Store 10 ints in array

import java.util.Scanner;

class Array2 {
	public static void main(String[] args) {
		int[] numArray = new int[10]; // Create empty array
		Scanner input = new Scanner(System.in); // Set up input
		
		for (int i = 0; i < numArray.length; i++) {
			System.out.print("Number " + (i + 1) + ": ");
			numArray[i] = input.nextInt();
		}
		
		// Output in order
		for (int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}
		
		// Output in reverse order
		for (int i = numArray.length - 1; i >= 0; i--) {
			System.out.println(numArray[i]);
		}
		
		// Output positive numbers only
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] > 0) {System.out.println(numArray[i]);}
		}
		
		// Output negative numbers only
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] < 0) {System.out.println(numArray[i]);}
		}
	}
}
