// Daniel Chen
// 31 October 2019
// Bar graph maker

import java.util.Scanner;

class pMethod3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Character: ");
		char c = sc.next().charAt(0);
		
		System.out.print("Occurrences: ");
		int times = sc.nextInt();
		
		printGraph(times, c);
	}
	public static void printGraph(int times, char c) {
		for (int i = 0; i < times; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
}
