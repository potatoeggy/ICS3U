// Daniel Chen
// 20 September 2019
// Iterate through user-input start and end numbers

import java.util.Scanner;

class For7 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Start number: ");
		int num1 = input.nextInt();

		System.out.print("End number: ");
		int num2 = input.nextInt();
		for (int i = num1; i < num2; i++) {
			System.out.println(i);
		}
	}
}
