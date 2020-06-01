// Daniel Chen
// 12 September 2019
// Var7

import java.util.Scanner;

class Var7 {
	public static void main(String[] args) {
		System.out.print("Length: ");
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		
		System.out.print("Width: ");
		Scanner scan2 = new Scanner(System.in);
		double y = scan.nextDouble();
		
		double area = x * y;
		double perimeter = 2 * (x + y);
		
		System.out.println("Area = " + area);
		System.out.println("Perimeter = " + perimeter);
		
		
	}
}	
