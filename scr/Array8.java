// Daniel Chen
// 7 October 2019
// Average of those who failed/passed

import java.util.Scanner;

class Array8 {
	public static void main(String[] args) {
		
		int times = 10;
		String[] firstnames = new String[times]; // Create empty arrays
		String[] lastnames = new String[times];
		int[] marks = new int[times];
		int broken = 0; // handle user exiting
		int accumulator = 0;
		Scanner input = new Scanner(System.in); // Set up input
		
		// Avoid clutter by telling user at beginning
		System.out.println("Enter negative number as mark to continue");
		for (int i = 0; i < times; i++) {
			broken++;
			// Get names and marks
			System.out.print("First name: ");
			do {
				firstnames[i] = input.nextLine(); // Java dumb and basically ignores the line again
			} while  (firstnames[i].equals(""));
			
			System.out.print("Last name: ");
			lastnames[i] = input.nextLine();
			
			System.out.print("Mark: ");
			marks[i] = input.nextInt(); // handle user exiting in advance
			if (marks[i] < 0) {
				broken--;
				break;
			}
			accumulator += marks[i];
		}

		for (int i = 0; i < broken; i++) {
			System.out.println(lastnames[i] + ", " + firstnames[i] + " - " + marks[i] + "%");
		}

		System.out.println("Class average: " + accumulator / broken + "%");
	}
}
