// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class InFile11 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
			
		File file = new File("file8");
		Scanner finput = new Scanner(file);
		double[] markArray = new double[10];
		double sum = 0;
		
		for (int i = 0; i < 10; i++) {
			markArray[i] = finput.nextDouble();
			sum += markArray[i];			
		}
		
		double tempswap = 0;
		for (int i = 0; i < markArray.length; i++) {
			for (int j = 1; j < markArray.length - i; j++) {
				if (markArray[j - 1] < markArray[j]) {
					tempswap = markArray[j - 1];
					markArray[j - 1] = markArray[j];
					markArray[j] = tempswap;
				}
			}
		}
		
		System.out.println(Arrays.toString(markArray));
		System.out.println(sum);
		finput.close();
	}
}
