// Daniel Chen
// 12 September 2019
// Var4

import java.util.Scanner;

class Var4 {
	public static void main(String[] args) {
		System.out.print("Number 1: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		System.out.print("Number 2: ");
		Scanner scan2 = new Scanner(System.in);
		int y = scan.nextInt();
		
		int z = x + y;
		
		System.out.println(x + " + " + y + " = " + z);
	}
}	
