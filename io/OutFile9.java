// Daniel Chen
// 19 November 2019
// Write highest mark to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile9 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file9");
		PrintWriter output = new PrintWriter(file);
		double temp = -1;
		double highest = -1;
		
		for (int i = 0; i < 10; i++) {
			do {
				try {
					System.out.print("Mark: ");
					temp = input.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid input. Try again.");
					temp = -1;
				}
				if (temp < 0 || temp > 100) {
					System.out.println("Invalid input. Try again.");
				} else if (temp > highest) {
					highest = temp;
				}
			} while (temp < 0 || temp > 100);
				
		}
		output.println(highest);
		output.close();
	}
}
