// Daniel Chen
// 17 September 2019
// Ask for temperature and output based on response

import java.util.Scanner;
// Import module for interactivity

class Sel3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Temperature: ");
		float temp = input.nextFloat();
		// Grab temperature
		if (temp > 30) { // Make decision based on above input
			System.out.println("hot");
		} else if (temp >= 20) {
			System.out.println("comfortable");
		} else if (temp >= 10) {
			System.out.println("cool");
		} else {
			System.out.println("cold");
		}
	}
}
