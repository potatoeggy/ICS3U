// Daniel Chen
// 25 October 2019
// Centimetres to inches

import java.util.Scanner;

class Method1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Centimetres: ");
		double cm = input.nextDouble();
		System.out.println(cm + " cm is " + cm2i(cm) + "\"");
	}
	public static double cm2i(double cm) {
		return cm / 2.54;
	}
}
