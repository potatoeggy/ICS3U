// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class InFile9 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file2");
		Scanner finput = new Scanner(file);
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			sum += finput.nextInt();
		}
		
		System.out.println(sum / 10.0);
		finput.close();
	}
}
