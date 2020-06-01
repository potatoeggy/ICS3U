// Daniel Chen
// 25 October 2019
// Find midpoint of two points

// Algorithm
// Set repeat loop to yes
// initialise array to store points
// loop the following
// user fills array
// pass array to midpoint function and print results
// ask user if they want to do it again
// unless answer is "n" loop

// midpoint function:
// formula on moodle, returning it in form of string

import java.util.Scanner;
import java.lang.Math;

class Method8 {
	public static void main(String[] args) {
		String repeat = "y";
		Scanner input = new Scanner(System.in);
		int[] points = new int[4];
		do {
		System.out.print("x1: ");
		points[0] = input.nextInt();
		System.out.print("x2: ");
		points[1] = input.nextInt();
		System.out.print("y1: ");
		points[2] = input.nextInt();
		System.out.print("y2: ");
		points[3] = input.nextInt();
		
		System.out.println("Midpoint: " + midpoint(points));
		
		System.out.print("Repeat? (Y/n)");
		repeat = input.next();
		} while (! repeat.equals("n"));
	}
	public static String midpoint(int[] points) {
		return "(" + (points[0] + points[1]) / 2 + ", " + (points[2] + points[3]) / 2 + ")";
	}
}
