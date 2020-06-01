// Daniel Chen
// 20 September 2019
// Repeat name x times, with numbers 2

import java.util.Scanner;

class For5 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Word: ");
		String word = input.nextLine();

		System.out.print("Times: ");
		int times = input.nextInt();
		for (int i = 0; i < times; i++) {
			System.out.println(word);
		}
	}
}
