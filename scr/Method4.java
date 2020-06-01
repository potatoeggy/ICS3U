// Daniel Chen
// 25 October 2019
// Find details of two points

import java.util.Scanner;
import java.lang.Math;

class Method4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] points = new int[4];
		System.out.print("x1: ");
		points[0] = input.nextInt();
		System.out.print("x2: ");
		points[1] = input.nextInt();
		System.out.print("y1: ");
		points[2] = input.nextInt();
		System.out.print("y2: ");
		points[3] = input.nextInt();
		
		System.out.println("Slope: " + slope(points));
		System.out.println("Midpoint: " + midpoint(points));
		System.out.println("Distance: " + distance(points));
	}
	public static double slope(int[] points) {
		return (points[3] - points[2])/(points[1] - points[0]);
	}
	public static String midpoint(int[] points) {
		return "(" + (points[0] + points[1]) / 2 + ", " + (points[2] + points[3]) / 2 + ")";
	}
	public static double distance(int[] points) {
		return Math.sqrt((points[1] - points[0])^2 + (points[3] - points[2])^2);
	}
}
