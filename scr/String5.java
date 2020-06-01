// Daniel Chen
// 14 November 2019
// print everything line by line

import java.util.Scanner;

class String5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.charAt(i));
		}
	}
}
