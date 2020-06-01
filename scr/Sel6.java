// Daniel Chen
// 17 September 2019
// Yell at user based on mark

import java.util.Scanner;
// Import module for interactivity

class Sel6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Mark: ");
		float mark = input.nextFloat();
		// Grab mark
		if (75 <= mark && mark <= 100) { // Make decision based on above input
			System.out.println("Great");
		} else if (mark >= 50 && mark <= 75) {
			System.out.println("Pass");
		} else if (0 <= mark && mark < 50) {
			System.out.println("Fail");
		} else {
			System.out.println("Invalid");
		}
	}
}
