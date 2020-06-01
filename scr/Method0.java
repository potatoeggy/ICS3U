// Daniel Chen
// 25 October 2019
// Discriminant

import java.util.Scanner;

class Method0 {
	static String discriminant(int[] quad) {
		int D = (quad[1]^2 - 4 * quad[0] * quad[2]);
		if (D < 0) {
			return D + " (No real roots)";
		} else if (D == 0) {
			return D + " (Two equal roots)";
		} else {
			return D + " (Two distinct real roots)";
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] quadratics = new int[3];
		for (int i = 0; i < quadratics.length; i++) {
			System.out.print("Number: ");
			quadratics[i] = input.nextInt();
		}
		System.out.println(discriminant(quadratics));
	}
}
