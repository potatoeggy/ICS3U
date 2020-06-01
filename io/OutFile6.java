// Daniel Chen
// 19 November 2019
// write sorted numbers to array

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile6 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file6");
		PrintWriter output = new PrintWriter(file);
		int[] numArray = new int[10];
		
		for (int i = 0; i < 10; i++) {
			System.out.print("Number: ");
			numArray[i] = input.nextInt();
		}
		
		for (int i = 0; i < 10; i++) {
			if (numArray[i] > 50) {
				output.println(numArray[i]);
			}
		}

		output.close();
	}
}
