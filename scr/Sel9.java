// Daniel Chen
// 17 September 2019
// Sel8 but lower

import java.util.Scanner;
// Import module for interactivity

class Sel9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Mark 1: ");
		float mark1 = input.nextFloat();
		System.out.print("Mark 2: ");
		float mark2 = input.nextFloat();
		if (mark1 < mark2) { // Make decision based on above input
			System.out.println(mark1);
		} else {
			System.out.println(mark2);
			
		}
	}
}
