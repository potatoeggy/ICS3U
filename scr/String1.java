// Daniel Chen
// 14 November 2019
// assign bool from input

import java.util.Scanner;

class String1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("\"true\" or \"false\": ");
		boolean bool = Boolean.parseBoolean(input.next());
		System.out.println(bool);
	}
}
