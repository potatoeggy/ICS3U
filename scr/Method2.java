// Daniel Chen
// 25 October 2019
// Pounds to kg

import java.util.Scanner;

class Method2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Pounds: ");
		double lb = input.nextDouble();
		System.out.println(lb + " lb is " + lb2kg(lb) + " kg");
	}
	public static double lb2kg(double lb) {
		return lb / 2.2;
	}
}
