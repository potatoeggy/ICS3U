// Daniel Chen
// 20 September 2019
// Repeat word x times, with numbers

import java.util.Scanner;

class For6 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Word: ");
		String word = input.nextLine();

		System.out.print("Times: ");
		int times = input.nextInt();
		for (int i = 1; i < times + 1; i++) {
			System.out.println(i + ". " + word);
		}
	}
}
