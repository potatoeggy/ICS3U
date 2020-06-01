// Daniel Chen
// 25 October 2019
// Find parallel slopes

// Algorithm
// Initialise two arrays, each holding four points 
// ask user to fill up all arrays
// pass arrays to slope function, if they're equal output they're parallel
// slope function is formula on moodle

import java.util.Scanner;
import java.lang.Math;

class Method7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] line1 = new int[4];
		int[] line2 = new int[4];
		String repeat = "y";
		do {
			System.out.println("Line 1:");
			System.out.print("x1: ");
			line1[0] = input.nextInt();
			System.out.print("x2: ");
			line1[1] = input.nextInt();
			System.out.print("y1: ");
			line1[2] = input.nextInt();
			System.out.print("y2: ");
			line1[3] = input.nextInt();
			
			System.out.println("Line 2:");
			System.out.print("x1: ");
			line2[0] = input.nextInt();
			System.out.print("x2: ");
			line2[1] = input.nextInt();
			System.out.print("y1: ");
			line2[2] = input.nextInt();
			System.out.print("y2: ");
			line2[3] = input.nextInt();
			
			if (slope(line1) == slope(line2)) {
				System.out.println("The two lines are parallel.");
			} else {
				System.out.println("The two lines are not parallel.");
			}
			
			System.out.print("Repeat? (Y/n)");
			repeat = input.next();
		} while (! repeat.equals("n"));
	}
	public static double slope(int[] points) {
		return (points[3] - points[2])/(points[1] - points[0]);
	}
}
