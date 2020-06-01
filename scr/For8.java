// Daniel Chen
// 20 September 2019
// Find sum of 5 numbers input by user

import java.util.Scanner;

class For8 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int accumulator = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Number: ");
			accumulator += input.nextInt();
		}
		System.out.println(accumulator);
	}
}
