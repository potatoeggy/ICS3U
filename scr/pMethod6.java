// Daniel Chen
// 31 October 2019
// Triangle former

import java.util.Scanner;

class pMethod6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Length 1: ");
		int x = sc.nextInt();
		
		System.out.print("Length 2: ");
		int y = sc.nextInt();
		
		System.out.print("Length 3: ");
		int z = sc.nextInt();
		
		calcTriangle(x, y, z);
	}
	public static void calcTriangle(int x, int y, int z) {
		int largest = x;
		int sum;
		if (y > x && y > z) {
			largest = y;
			sum = x + z;
		} else if (z > x) {
			largest = z;
			sum = x + y;
		} else {
			sum = y + z;
		}
		
		if (sum > largest) {
			System.out.println("Triangle will be created.");
		} else {
			System.out.println("Triangle will not be created.");
		}
	}
}
