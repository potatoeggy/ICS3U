// Daniel Chen
// 11 October 2019
// Prompts the user to enter 10 integers and stores the values in an array then processes and outputs

import java.util.Scanner;
import java.util.Arrays;

class ArrayProcessing1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Prepare for input
		int[] array = new int[10]; // Initialise array
		
		// Initialise variables to handle array processing
		int largest = 0;
		int smallest = 2147483647; // might be an easier way to do this
		int accumulator = 0;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("Number: ");
			array[i] = input.nextInt(); // Repeatedly ask for input and store in array
			
			if (array[i] > largest) { // handle largest number
				largest = array[i];
			}
			if (array[i] < smallest) { // handle smallest number
				smallest = array[i];
			}
			
			accumulator += array[i]; // handle sum of all numbers
		} // End for loop
		
		// handle switching of lists
		int[] fourfiveswitchedarray = array.clone();
		fourfiveswitchedarray[3] = array[4];
		fourfiveswitchedarray[4] = array[3];
		
		// handle sorted array
		int[] sortedArray = array.clone();
		Arrays.sort(sortedArray);
		
		// Output arrays
		System.out.println("List in chronological order: " + Arrays.toString(array));
		
		// Output max
		System.out.println("Largest: " + largest);
		
		// Output min
		System.out.println("Smallest: " + smallest);
		
		// Output sum
		System.out.println("Sum: " + accumulator);
		
		// Output switched array
		System.out.println("List switching fourth and fifth elements: " + Arrays.toString(fourfiveswitchedarray));
		
		// Output sorted array
		System.out.println("List in ascending order: " + Arrays.toString(sortedArray));
		
	} // End main
} // End class
