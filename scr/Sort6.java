// Daniel Chen
// 18 October 2019
// Sorting any number of strings alphabetically

import java.util.Scanner;
import java.util.Arrays;

class Sort6 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("# of Strings: ");
		String names[] = new String[input.nextInt()]; // declare array with user input
		
		for (int i = 0; i < names.length; i++) { // request user input 5 times
			System.out.print("Name: ");
			do { // scanner not reading things strikes again
			names[i] = input.nextLine();
			} while ("".equals(names[i]));
		
		}
		
		for (int i = 0; i < names.length; i++) {// bubble sort template
			for (int j = 1; j < names.length - i; j++) {
				if (names[j - 1].compareTo(names[j]) > 0) { // returns 0 if lexicographically identical, less than 0 if greater lexicographically, and greater than 0 otherwise
					String temp = names[j]; // typical swap code
					names[j] = names[j - 1];
					names[j - 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(names)); // faster than using for loop I was lazy
	}
}
