// Daniel Chen
// 20 September 2019
// Find highest of numbers input by user

import java.util.Scanner;

class For10 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int notReallyAnAccumulator = 0;
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Number: ");
			temp = input.nextInt();
			if (temp > notReallyAnAccumulator) {notReallyAnAccumulator = temp;}
		}
		System.out.println(notReallyAnAccumulator);
	}
}
