// Daniel Chen
// 25 October 2019
// Kilometres to miles

import java.util.Scanner;

class Method3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Kilometres: ");
		double km = input.nextDouble();
		System.out.println(km + " km is " + km2mi(km) + " mi");
	}
	public static double km2mi(double km) {
		return km / 1.609;
	}
}
