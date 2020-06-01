// Daniel Chen
// 31 October 2019
// Rectangle generator

import java.util.Scanner;

class pMethod4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Height: ");
		int height = sc.nextInt();
		
		System.out.print("Width: ");
		int width = sc.nextInt();
		
		System.out.print("Character: ");
		char c = sc.next().charAt(0);
		
		printRectangle(width, height, c);
	}
	public static void printRectangle(int width, int height, char c) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
