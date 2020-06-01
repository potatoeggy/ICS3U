// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile4 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file11");
		Scanner finput = new Scanner(file);
		while (finput.hasNextLine()) {
			System.out.println(finput.nextLine());
		}
		finput.close();
	}
}
