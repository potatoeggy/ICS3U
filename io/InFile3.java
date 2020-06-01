// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile3 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Filename: ");		
		File file = new File(input.nextLine());
		Scanner finput = new Scanner(file);
		while (finput.hasNextLine()) {
			System.out.println(finput.nextLine());
		}
		finput.close();
	}
}
