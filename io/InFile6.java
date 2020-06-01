// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class InFile6 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file7");
		Scanner finput = new Scanner(file);
		String[] array = finput.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" "); // being lazy bites me later on
		
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		finput.close();
	}
}
