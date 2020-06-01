// Daniel Chen
// 14 November 2019
// pig latin but not actually pig latin

import java.util.Scanner;

class String3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		System.out.println("First character: " + string.charAt(0));
		System.out.println("Last character: " + string.substring(string.length() - 1));
	}
}
