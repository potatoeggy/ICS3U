// Daniel Chen
// 19 November 2019
// write marks to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile8 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file8");
		PrintWriter output = new PrintWriter(file);
		double temp = -1;
		
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
				}
			} while (temp < 0 || temp > 100);
				
			output.println(temp);
		}
		output.close();
	}
}
