// Daniel Chen
// 17 September 2019
// Ask the user for a number between 1 and 10.  If the value is larger than or equal to 5, then output the words “You won!”

import java.util.Scanner;

class Sel1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number (1-10): ");
		float num = input.nextFloat();
		if (num >= 5.0) {
			System.out.println("You win!");
		}
	}
}
