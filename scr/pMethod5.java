// Daniel Chen
// 31 October 2019
// Sorter

import java.util.Scanner;

class pMethod5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number 1: ");
		int x = sc.nextInt();
		
		System.out.print("Number 2: ");
		int y = sc.nextInt();
		
		System.out.print("Number 3: ");
		int z = sc.nextInt();
		
		sortNums(x, y, z);
	}
	public static void sortNums(int x, int y, int z) {
		int smallest = x;
		if (y < x && y < z) {
			smallest = y;
		} else if (z < x) {
			smallest = z;
		}
		
		int largest = x;
		if (y > x && y > z) {
			largest = y;
		} else if (z > x) {
			largest = z;
		}
		System.out.println("Smallest = " + smallest);
		System.out.println("Largest = " + largest);
	}
}
