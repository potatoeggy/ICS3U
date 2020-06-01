// Daniel Chen
// 14 November 2019
// display random character in string

import java.util.Scanner;

class String7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		
		// part a
		System.out.println(string.replaceAll(" ", "").charAt((int) (Math.random() * string.length())));
		
		// part b
		String[] stringArray = string.split(" ");
		System.out.println(stringArray[(int) (Math.random() * stringArray.length)]);
	}
}
