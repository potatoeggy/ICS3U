// Daniel Chen
// 31 October 2019
// Rectangle area calculator

import java.util.Scanner;

class pMethod1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Length: ");
		double length = sc.nextDouble();
		
		System.out.print("Width: ");
		double width = sc.nextDouble();
		
		writeArea(length, width);
	}
	public static void writeArea(double l, double w) {
		System.out.println("Area = " + Math.round(l*w));
	}
}
