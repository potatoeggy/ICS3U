// Daniel Chen
// 14 November 2019
// count "e"s in string

import java.util.Scanner;


class String4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		int chars = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'e') {
				chars++;
			}
		}
		System.out.println("Lowercase \"e\"s in string: " + chars);
	}
}
