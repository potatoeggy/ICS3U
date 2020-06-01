// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile2 {
	public static void main(String[] args) throws Exception {
		File file = new File("file3");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		input.close();
	}
}
