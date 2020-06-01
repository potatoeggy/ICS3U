// Daniel Chen
// 19 November 2019
// write mark and name

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile13 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file13");
		PrintWriter output = new PrintWriter(file);
		String[] nameArray = new String[5];
		int[] markArray = new int[5];
		
		for (int i = 0; i < nameArray.length; i++) {
			System.out.print("Name: ");
			nameArray[i] = input.nextLine();
			
			System.out.print("Mark: ");
			markArray[i] = input.nextInt();
			input.nextLine();
		}
		
		for (int i = 0; i < nameArray.length; i++) {
			output.println(nameArray[i] + " " + markArray[i] + "%");
		}
		
		output.close();
	}
}
