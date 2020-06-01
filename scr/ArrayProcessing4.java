// Daniel Chen
// 11 October 2019
// Having fun with String arrays

import java.util.*;

class ArrayProcessing4 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] stringList = {"one","two","five","four","six","three"}; // initialise array
		
		// swapping the two elements on the list
		String temp = stringList[5];
		stringList[5] = stringList[2];
		stringList[2] = temp;
		
		System.out.println(Arrays.toString(stringList));
		
		// Ask user to switch things on list
		System.out.print("Number (0-5): ");
		int i = input.nextInt();
		
		System.out.print("Number (0-5): ");
		int j = input.nextInt();
		
		// swapping the two elements on the list again but this time with variables
		temp = stringList[j];
		stringList[j] = stringList[i];
		stringList[i] = temp;
		
		System.out.println(Arrays.toString(stringList));
	}
}
