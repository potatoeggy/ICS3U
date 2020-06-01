// Daniel Chen
// 23 October 2019
// Student grade statistics

import java.util.Scanner;

class ArraysFormativePart2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Set up input processing
		
		String[] names = new String[100];
		float[] marks = new float[100]; // initialise required arrays
		int filled = 0; // handle checking empty elements
		
		// get user input to fill arrays
		String temp;
		System.out.println("\"quit\" to quit");
		for (int i = 0; i < names.length; i++) {
			System.out.print("Name " + (i + 1) + ": ");
			temp = null; // work around Scanner not scanning
			do {
			temp = input.nextLine();
			} while ("".equals(temp)); // work around Scanner not scanning
			if (temp.equals("quit")) { // handle moving on
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null) {
						filled += 1;
					}
				}
				break;
			} else {
				names[i] = temp;
			}
			
			System.out.print("Mark " + (i + 1) + ": ");
			marks[i] = input.nextFloat();
		}
		
		int exit = 0; // handles exiting program
		int menuSelect = 0; // handles which thing user does
				
		
		while (exit != 1) { // main menu loop
			System.out.println("Menu");
			System.out.println("\nWhat would you like to do?");
			System.out.println("Enter the corresponding number.");
			System.out.println("\n1) Display all names and marks");
			System.out.println("2) Display highest mark");
			System.out.println("3) Display average mark");
			System.out.println("4) Update mark");
			System.out.println("5) Add new student");
			System.out.println("6) Delete student");
			System.out.println("7) Sort names alphabetically");
			System.out.println("8) Sort marks in ascending order");
			System.out.println("9) Exit");
			
			menuSelect = input.nextInt();
			
			if (menuSelect == 1) {
				// print out everyone's names and marks
				for (int i = 0; i < filled; i++) {
					System.out.println(names[i] + " " + marks[i] + "%");
				}
				
			} else if (menuSelect == 2) {
				// print out highest mark
				int highest = 0;
				float topmark = 0;
				for (int i = 0; i < filled; i++) {
					if (marks[i] > topmark) { // loop through and get highest mark
						highest = i; // indicator of where top value is located
						topmark = marks[i]; // holds highest value at all times
					}
				}
				System.out.println(names[highest] + " has the highest grade with a mark of " + marks[highest] + "%"); // output mark to user
				
			} else if (menuSelect == 3) {
				// print out average mark
				int accumulator = 0;
				for (int i = 0; i < filled; i++) {
					accumulator += marks[i];
				}
				System.out.println("The average mark of all " + filled + " students is " + (float)accumulator/filled + "%");
			
			} else if (menuSelect == 4) {
				// update mark
				// ask for input as to which student to update
				System.out.print("Student: ");
				String changingStudent = "";
				do {
				changingStudent = input.nextLine(); // handle Scanner not scanning
				} while ("".equals(changingStudent));
				
				// search for student
				int studentFound = 0;
				for (int i = 0; i < filled; i++) {
					if (names[i].equals(changingStudent)) {
						System.out.println(changingStudent + " currently has a mark of " + marks[i] + "%.");
						System.out.print("Updated mark: ");
						marks[i] = input.nextFloat(); // update student mark
						studentFound = 1;
					}
				}
				if (studentFound == 0) {
					System.out.println("Student not found.");
				}
			
			} else if (menuSelect == 5) {
				// add new student
				if (filled == 100) {
					System.out.print("Maximum number of students reached. Please remove a student first."); // handle too many students
				} else {
					System.out.print("Name " + (filled + 1) + ": ");
					do {
						names[filled] = input.nextLine();
					} while ("".equals(names[filled])); // handle Scanner not scanning
					
					System.out.println("Mark " + (filled + 1) + ": ");
					marks[filled] = input.nextFloat();
					
					filled++;
				}
				
			} else if (menuSelect == 6) {
				// delete student
				String deletedStudent = "";
				System.out.print("Student to delete: ");
				do {
					deletedStudent = input.nextLine();
				} while ("".equals(deletedStudent));
				
				// search for student to be deleted
				int studentFound = 0;
				for (int i = 0; i < filled; i++) {
					if (names[i].equals(deletedStudent)) {
						studentFound = 1;
						
						// move everyone after it one index back
						for (int j = i + 1; j < filled; j++) {
							names[i] = names[j];
							marks[i] = marks[j];
						}
						names[filled - 1] = null;
						marks[filled - 1] = 0;
						filled--;
					}
				}
				
				// tell user if student was actually deleted
				if (studentFound == 1) {
					System.out.println("Student deleted.");
				} else {
					System.out.println("Student not found.");
				}
			
			} else if (menuSelect == 7) {
				// sort names
				for (int i = 0; i < filled; i++) {
					for (int j = 1; j < filled - i; j++) {
						if (names[j].compareTo(names[j - 1]) < 0) {
							String tempString = names[j];
							names[j] = names[j - 1];
							names[j - 1] = tempString;
						}
					}
				}
				System.out.println("Sorting complete.");
			
			} else if (menuSelect == 8) {
				// sort marks 
				for (int i = 0; i < filled; i++) {
					for (int j = 1; j < filled - i; j++) {
						if (marks[j] < marks[j - 1]) {
							float tempMark = marks[j];
							marks[j] = marks[j - 1];
							marks[j - 1] = tempMark;
						}
					}
				}
			} else if (menuSelect == 9) {
				// exit
				exit = 1;
				System.out.println("Exiting");
			} else {
				// invalid number
				System.out.println("Invalid number.");
			}
		}
	}
}
