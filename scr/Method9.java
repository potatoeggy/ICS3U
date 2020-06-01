// Daniel Chen
// 25 October 2019
// Heron formula thingy to find triangle area

// Algorithm
// create arrays for triangle lines
// create array for triangle lengths
// loop following:
// ask for triangle points
// pass triangle points through length formula into heron formula
// print heron formula
// ask for repetition
// if user doesn't want to repeat, leave

// distance function:
// take two points in array
// use distance formula on moodle to get a double
// return that

// heron function:
// accept array of triangle lengths
// solve for S as shown on moodle
// solve for area as shown on moodle
// return area, rounded

import java.util.Scanner;
import java.lang.Math;

class Method9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] p1 = new double[2];
		double[] p2 = new double[2];
		double[] p3 = new double[2];
		double[] lengths = new double[3];
		String repeat = "y";
		do {
			System.out.print("x1: ");
			p1[0] = input.nextInt();
			System.out.print("y1: ");
			p1[1] = input.nextInt();
			
			System.out.print("x2: ");
			p2[0] = input.nextInt();
			System.out.print("y2: ");
			p2[1] = input.nextInt();
			
			System.out.print("x3: ");
			p3[0] = input.nextInt();
			System.out.print("y3: ");
			p3[1] = input.nextInt();
			
			double a = distance(p1, p2);
			double b = distance(p1, p3);
			double c = distance(p2, p3);
			
			
			System.out.println("Area = " + heron(a, b, c));
			System.out.print("Repeat? (Y/n)");
			repeat = input.next();
			
		} while (! repeat.equals("n"));
		
	}
	public static double distance(double[] p1, double[] p2) {
		return Math.sqrt((p1[1] - p1[0]) * (p1[1] - p1[0]) + (p2[1] - p2[0]) * (p2[1] - p2[0]));
	}
	public static double heron(double a, double b, double c) {
		double S = (a + b + c) / 2;
		return Math.round(Math.sqrt(S * (S - a) * (S - b) * (S - c)));
	}	
}
