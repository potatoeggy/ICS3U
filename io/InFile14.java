// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile14 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file11");
		Scanner finput = new Scanner(file);
		String[] stringArray = finput.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" "); // wouldn't it be nice if this wasn't such an ugly chunk of code?
		double[] markArray = new double[10];
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print("Mark for " + stringArray[i] + ": ");
			markArray[i] = input.nextDouble();
		}
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println(stringArray[i] + " - " + markArray[i] + "%");
		}
				
		finput.close();
	}
}
