// Daniel Chen
// 19 November 2019
// write sorted number to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile7 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file7");
		PrintWriter output = new PrintWriter(file);
		int[] numArray = new int[15];
		
		for (int i = 0; i < numArray.length; i++) {
			System.out.print("Number (1-20): ");
			numArray[i] = input.nextInt();
		}
		
		int tempswap = 0;
		for (int i = 0; i < numArray.length; i++) {
			for (int j = 1; j < numArray.length - i; j++) {
				if (numArray[j - 1] > numArray[j]) {
					tempswap = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = tempswap;
				}
			}
		}
		
		output.println(Arrays.toString(numArray));
		output.close();
	}
}
