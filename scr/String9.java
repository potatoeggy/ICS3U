// Daniel Chen
// 14 November 2019
// word remover

import java.util.Scanner;

class String9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		
		System.out.print("Remove string: ");
		String replacer = input.nextLine();
		string = string.replaceAll(replacer + " ", "");
		string = string.replaceAll(" " + replacer, "");
		
		System.out.println(string);
	}
}
