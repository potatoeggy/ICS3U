// Daniel Chen
// 25 October 2019
// Identifying if a triangle is right-angled

// Algorithm
// create array for triangle points
// create array for triangle lengths
// loop following:
// ask for triangle points
// pass triangle points into length function
// pass lengths two at a time into if right angled function

import java.util.Scanner;
import java.lang.Math;

class Method10 {
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
			
			lengths[0] = distance(p1, p2);
			lengths[1] = distance(p1, p3);
			lengths[2] = distance(p2, p3);
			
			if (rightAngled(lengths)) {
				System.out.println("This triangle is right-angled.");
			}
			
			System.out.print("Repeat? (Y/n)");
			repeat = input.next();
			
		} while (! repeat.equals("n"));
		
	}
	public static double distance(double[] p1, double[] p2) {
		return Math.sqrt((p1[1] - p1[0]) * (p1[1] - p1[0]) + (p2[1] - p2[0]) * (p2[1] - p2[0]));
	}
	public static boolean rightAngled(double[] l) {
		double a = sq(l[0]);
		double b = sq(l[1]);
		double c = sq(l[2]);
		if (l[0] == Math.sqrt(b + c) || l[1] == Math.sqrt(a + c) || l[2] == Math.sqrt(b + a)) {
			return true;
		} else {
			return false;
		}
	}
	public static double sq(double i) {
		return i * i;
	}
}
		
