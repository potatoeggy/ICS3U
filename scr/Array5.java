// Daniel Chen
// 7 October 2019
// Shame those who failed or compliment those who passed

import java.util.Scanner;

class Array5 {
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
		
		for (int i = 0; i < times; i++) {
			if ("pass".equalsIgnoreCase(passFail) && marks[i] >= 50) {
				System.out.println(lastnames[i] + ", " + firstnames[i] + " - " + marks[i] + "%");
			} else if ("fail".equalsIgnoreCase(passFail) && marks[i] < 50) {
				System.out.println(lastnames[i] + ", " + firstnames[i] + " - " + marks[i] + "%");
			}
		}
	}
}
