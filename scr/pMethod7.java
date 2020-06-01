// Daniel Chen
// 31 October 2019
// Build a triangle

import java.util.Scanner;

class pMethod7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Height: ");
		int height = sc.nextInt();
		buildTriangle(height);
	}
	
	public static void buildTriangle(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
