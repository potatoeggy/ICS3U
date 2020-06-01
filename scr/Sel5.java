// Daniel Chen
// 17 September 2019
// Guess chosen numbers

import java.util.Scanner;
// Import module for interactivity

class Sel5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Number: ");
		float num = input.nextFloat();
		System.out.print("Guess number: ");
		float num2 = input.nextFloat();
		// Grab number
		if (num == num2) { // Make decision based on above input
			System.out.println("you got it");
		} else {
			System.out.println("guess again");
		}
	}
}
