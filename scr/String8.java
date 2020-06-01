// Daniel Chen
// 14 November 2019
// lowerCamelCase converter from spaces

import java.util.Scanner;

class String8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("String: ");
		String string = input.nextLine();
		
		String[] stringArray = string.split(" ");
		stringArray[0] = stringArray[0].toLowerCase();
		
		for (int i = 1; i < stringArray.length; i++) {
			stringArray[i] = stringArray[i].substring(0, 1).toUpperCase() + stringArray[i].substring(1, stringArray[i].length()).toLowerCase();
		}
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(stringArray[i]);
		}		
	}
}
