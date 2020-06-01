// Daniel Chen
// 19 November 2019
// Write numArray to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile4 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Filename: ");
		File file = new File(input.nextLine());
		PrintWriter output = new PrintWriter(file);
		int[] numArray = new int[20];
		
		for (int i = 0; i < 20; i++) {
			System.out.print("Number: ");
			numArray[i] = input.nextInt();
		}
		output.println(Arrays.toString(numArray));
		output.close();
	}
}
