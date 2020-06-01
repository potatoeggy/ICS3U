// Daniel Chen
// 17 September 2019
// Guess number

import java.util.Scanner;
// Import module for interactivity

class Sel4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Number: ");
		float num = input.nextFloat();
		// Grab number
		if (num == 66) { // Make decision based on above input
			System.out.println("you got it");
		} else {
			System.out.println("guess again");
		}
	}
}
