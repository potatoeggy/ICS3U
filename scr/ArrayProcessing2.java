// Daniel Chen
// 11 October 2019
// Determine average of two marks for students

import java.util.*;

class ArrayProcessing2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // handle input
		
		// initialise various arrays
		int arrayLength = 10;
		String[] nameList = new String[arrayLength];
		float[] mathList = new float[arrayLength];
		float[] scienceList = new float[arrayLength];
		
		// ask user to input their marks
		for (int i = 0; i < arrayLength; i++) {
			System.out.print("Name: ");
			do {
				nameList[i] = input.nextLine();
			} while ("".equals(nameList[i]));
			
			System.out.print("Math mark: ");
			mathList[i] = input.nextFloat();
			
			System.out.print("Science mark: ");
			scienceList[i] = input.nextFloat();
		}
		
		// Print averages
		System.out.println("Averages:");
		for (int i = 0; i < arrayLength; i++) {
			System.out.println(nameList[i] + " - " + (mathList[i] + scienceList[i]) / 2.0 + "%");
		}
	}
}
