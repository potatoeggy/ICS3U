// Daniel Chen
// 18 October 2019
// Sorting strings and integers with integers following sorted order of strings

import java.util.Scanner;
import java.util.Arrays;

class Sort7 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		String names[] = new String[5]; // declare arrays
		float marks[] = new float[5];
		
		// declare temporary variables
		String tempString;
		float tempFloat;
		
		for (int i = 0; i < 5; i++) { // request user input 5 times
			System.out.print("Name: ");
			do { // fix Scanner ignoring below line
			names[i] = input.nextLine();
			} while ("".equals(names[i]));
			
			System.out.print("Mark: ");
			marks[i] = input.nextFloat();
		}
		
		for (int i = 0; i < marks.length; i++) { // bubble sort template
			for (int j = 1; j < marks.length - i; j++) {
				if (marks[j - 1] >s marks[j]) { // 
					tempString = names[j]; // typical swap code
					names[j] = names[j - 1];
					names[j - 1] = tempString;
					
					// swap marks too
					tempFloat = marks[j];
					marks[j] = marks[j - 1];
					marks[j - 1] = tempFloat;
				}
			}
		}
		
		// Output sorted arrays
		for (int i = 0; i < marks.length; i++) {
			System.out.println(marks[i] + "% - " + names[i]);
		}
	}
}
