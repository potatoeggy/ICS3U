// Daniel Chen
// 14 November 2019
// display characters in range

import java.util.Scanner;


class String6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		System.out.print("Start and end range (inclusive) : ");
		int start = input.nextInt();
		int end = input.nextInt();
		
		if (start > 0 && end < string.length() + 1) {
			for (int i = start - 1; i < end; i++) {
				System.out.println(string.charAt(i));
			}
		} else {
			System.out.println("Out of range");
		}
	}
}
