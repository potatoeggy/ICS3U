// Daniel Chen
// 7 October 2019
// Print words in reverse order of entry

import java.util.Scanner;

class Array4 {
	public static void main(String[] args) {
		String[] wordArray = new String[10]; // Create empty array
		Scanner input = new Scanner(System.in); // Set up input
		
		for (int i = 0; i < wordArray.length; i++) {
			System.out.print("Word " + (i + 1) + ": ");
			wordArray[i] = input.nextLine();
		}
		
		// Output in reverse order
		for (int i = wordArray.length - 1; i >= 0; i--) {
			System.out.println(wordArray[i]);
		}
	}
}
