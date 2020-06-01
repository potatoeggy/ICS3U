// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class InFile10 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file2");
		Scanner finput = new Scanner(file);
		int[] array = new int[10];
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			array[i] = finput.nextInt();
			sum += array[i];
		}
		
		System.out.println(Arrays.toString(array));
		System.out.println(sum);
		finput.close();
	}
}
