// Daniel Chen
// 11 October 2019
// Phone numbers

import java.util.*;

class ArrayProcessing3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Set up arrays
		String[] nameList = new String[10];
		float[] phoneList = new float[10]; // don't think substrings are allowed so we do this mathematically
		
		// Grab user input
		for (int i = 0; i < nameList.length; i++) {
			System.out.print("Name: ");
			do {
			nameList[i] = input.nextLine();
			} while ("".equals(nameList[i])); // Check for dumb Java scanner mechanics (i.e.: ignoring the line above)
			
			System.out.print("Phone number (xxxxxxxxxx): ");
			phoneList[i] = input.nextFloat();
		}
		
		// Output people with 905 area code
		System.out.println("People with area code 905: ");
		for (int i = 0; i < nameList.length; i++) {
			if (Math.floor(phoneList[i] / 10000000.0) == 905) { // Mathematical equation to find out if 905 is first three digits of phone num
				System.out.println(nameList[i]);
			}
		}
		
		// Output people with 905 area code + number
		System.out.println("People with area code 905: ");
		for (int i = 0; i < nameList.length; i++) {
			if (Math.floor(phoneList[i] / 10000000.0) == 905) {
				System.out.println(nameList[i] + " - " + "(905) " + ((int) Math.floor((phoneList[i] - 9050000000.0) / 10000.0)) + "-" + ((int) Math.floor(phoneList[i] / 10000000))); // Large concatenation thing
			}
		}
	}
}
