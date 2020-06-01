// Daniel Chen
// 19 November 2019
// Write username array to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile11 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file11");
		PrintWriter output = new PrintWriter(file);
		String[] nameArray = new String[5];
		for (int i = 0; i < nameArray.length; i++) {
			System.out.print("Name: ");
			nameArray[i] = input.nextLine();
		}
		
		output.println(Arrays.toString(nameArray));
		output.close();
	}
}
