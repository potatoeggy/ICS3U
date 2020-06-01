// Daniel Chen
// 20 September 2019
// Find average of numbers input by user

import java.util.Scanner;

class For9 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float accumulator = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print("Number: ");
			accumulator += input.nextFloat();
		}
		System.out.println(accumulator / 3.0);
	}
}
