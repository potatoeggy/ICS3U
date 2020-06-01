// Daniel Chen
// 25 October 2019
// Squares number

// Algorithm
// ask for input and store in variable
// function is defined as returning variable * variable
// pass variable through function and print result

import java.util.Scanner;

class Method5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number: ");
		int number = input.nextInt();
		System.out.println(number + " squared is " + squared(number));
	}
	public static int squared(int num) {
		return num * num;
	}
}
