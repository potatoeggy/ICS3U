// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile12 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file12");
		Scanner finput = new Scanner(file);
		
		String[] stringArray = finput.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" "); // I despise whoever made the irresponsible decision to be lazy when making the other program
		System.out.println(stringArray[stringArray.length - 1]);
		finput.close();
	}
}
