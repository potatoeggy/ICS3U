// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile1 {
	public static void main(String[] args) throws Exception {
		File file = new File("file1");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			System.out.println(input.next());
		}
		input.close();
	}
}
