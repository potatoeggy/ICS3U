// Daniel Chen
// 11 October 2019
// Array processing as a group

import java.util.Scanner;

class ArrayProcessing0 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// All predetermined code
		int MAX;
		System.out.print("List size: ");
		MAX = input.nextInt();
		int[] array = new int[MAX];
		
		// common code, for sake of modularity everything inside the for loops below 
		for (int i = 0; i < MAX; i++) {
			array[i] = input.nextInt();
		}
		
		// exercise 1
		int accumulator1 = 0;
		for (int i = 0; i < MAX; i++) {
			accumulator1 += array[i];
		}
		System.out.println("Sum: " + accumulator1);
		
		// exercise 2
		int smallest = 2147483647;
		for (int i = 0; i < MAX; i++) {
			if (array[i] < smallest) {
				smallest = array[i];
			}
		}
		System.out.println("Smallest: " + smallest);
		
		// exercise 3
		int largest = 0;
		for (int i = 0; i < MAX; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		}
		System.out.println("Largest: " + largest);
		
		// exercise 4
		System.out.print("Does this exist: ");
		int storeNum = input.nextInt();
		System.out.println("It exists at: ");
		for (int i = 0; i < MAX; i++) {
			if (storeNum == array[i]) {
				System.out.println("Index: " + i);
			}
		}
		
		// exercise 5
		int accumulator5 = 0;
		for (int i = 0; i < MAX; i++) {
			accumulator5 += array[i];
		}
		System.out.println("Average: " + accumulator5/10);
		
	}
}
