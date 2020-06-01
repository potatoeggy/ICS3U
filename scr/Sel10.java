// Daniel Chen
// 17 September 2019
// Output "Hello" x times equal to input

import java.util.Scanner;
// Import module for interactivity

class Sel10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Number (1-5): ");
		int num = input.nextInt();
		if (num == 1) { // Make decision based on above input
			System.out.println("hello");
		} else if (num == 2) {
			System.out.println("hello\nhello");
		} else if (num == 3) {
			System.out.println("hello\nhello\nhello");
		} else if (num == 4) {
			System.out.println("hello\nhello\nhello\nhello");
		} else if (num == 5) {
			System.out.println("hello\nhello\nhello\nhello\nhello");
		}
	}
}
