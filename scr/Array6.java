// Daniel Chen
// 7 October 2019
// Average of those who failed/passed

import java.util.Scanner;

class Array6 {
	public static void main(String[] args) {
		int times = 10;
		String[] firstnames = new String[times]; // Create empty arrays
		String[] lastnames = new String[times];
		int[] marks = new int[times];
		Scanner input = new Scanner(System.in); // Set up input
		
		for (int i = 0; i < times; i++) {
			// Get names and marks
			System.out.print("First name " + (i + 1) + ": ");
			firstnames[i] = input.nextLine();
			if (firstnames[i].equals("")) {
				firstnames[i] = input.nextLine(); //Java dumb and doesn't see it again
			}
			
			System.out.print("Last name " + (i + 1) + ": ");
			lastnames[i] = input.nextLine();
			
			System.out.print("Mark " + (i + 1) + ": ");
			marks[i] = input.nextInt();
		}
		
		System.out.print("List to see (PASS/fail): ");
		String passFail = input.nextLine();
		if ("".equals(passFail)) { // Java dumb and doesn't see it AGAIN
			passFail = input.nextLine();
		}
		
		int passAccumulator = 0;
		int failAccumulator = 0;
		int passCounter = 0;
		int failCounter = 0;
		
		// Accumulate
		for (int i = 0; i < times; i++) {
			if (marks[i] >= 50) {
				passAccumulator += marks[i];
				passCounter++;
			} else {
				failAccumulator += marks[i];
				failCounter++;
			}
		}
		// Output user result
		if ("fail".equalsIgnoreCase(passFail)) {
			System.out.println("Average of those who failed is " + failAccumulator / failCounter + "%");
		} else {
			System.out.println("Average of those who passed is " + passAccumulator / passCounter + "%");
		}
	}
}
