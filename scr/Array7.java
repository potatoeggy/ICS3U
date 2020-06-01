// Daniel Chen
// 7 October 2019
// 0 to exit

import java.util.Scanner;

class Array7 {
	public static void main(String[] args) {
		
		// init variables
		int times = 10; // everything relative is better
		int broken = 0; // just in case user doesn't like us and quits
		int[] integers = new int[times]; // no way to get around this because dynamic arrays don't exist
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < times; i++) {
			System.out.print("Number ('0' to continue): ");
			integers[i] = input.nextInt();
			broken++;
			if (integers[i] == 0) {
				broken--;
				break;
			}
		}
		
		// Positive numbers
		System.out.println("Positive integers: ");
		for (int i = 0; i < broken; i++) {
			if (integers[i] > 0) {
				System.out.println(integers[i]);
			}
		}
		
		// I don't know how to optimise this but I'm sure it's possible
		System.out.println("Negative integers: ");
		for (int i = 0; i < broken; i++) {
			if (integers[i] < 0) {
				System.out.println(integers[i]);
			}
		}
	}
}
