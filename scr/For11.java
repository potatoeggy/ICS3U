// Daniel Chen
// 20 September 2019
// Find lowest of marks input by user

import java.util.Scanner;

class For11 { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int notReallyAnAccumulator = 1000000; // In theory no set of marks should ever reach past this
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Mark: ");
			temp = input.nextInt();
			if (temp < notReallyAnAccumulator) {notReallyAnAccumulator = temp;}
		}
		System.out.println(notReallyAnAccumulator);
	}
}
