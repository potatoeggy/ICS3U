// Daniel Chen
// 19 November 2019
// Write username array to file in alpha order

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile12 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file12");
		PrintWriter output = new PrintWriter(file);
		String[] nameArray = new String[5];
		for (int i = 0; i < nameArray.length; i++) {
			System.out.print("Name: ");
			nameArray[i] = input.nextLine();
		}
		
		String tempswap;
		for (int i = 0; i < nameArray.length; i++) {
			for (int j = 1; j < nameArray.length - i; j++) {
				if (nameArray[j - 1].compareTo(nameArray[j]) > 0) {
					tempswap = nameArray[j - 1];
					nameArray[j - 1] = nameArray[j];
					nameArray[j] = tempswap;
				}
			}
		}
		
		output.println(Arrays.toString(nameArray));
		output.close();
	}
}
