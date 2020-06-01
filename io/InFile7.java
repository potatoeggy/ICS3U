// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class InFile7 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
			
		File file = new File("file4");
		Scanner finput = new Scanner(file);
		String[] stringArray = finput.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" "); // me and my lazy code
		int[] intArray = new int[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		int tempswap = 0;
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 1; j < intArray.length - i; j++) {
				if (intArray[j - 1] > intArray[j]) {
					tempswap = intArray[j - 1];
					intArray[j - 1] = intArray[j];
					intArray[j] = tempswap;
				}
			}
		}
		
		System.out.println(Arrays.toString(intArray));
		finput.close();
	}
}
