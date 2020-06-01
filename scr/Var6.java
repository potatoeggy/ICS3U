// Daniel Chen
// 12 September 2019
// Var6

import java.util.Scanner;

class Var6 {
	public static void main(String[] args) {
		System.out.print("Number 1: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		System.out.print("Number 2: ");
		Scanner scan2 = new Scanner(System.in);
		int y = scan.nextInt();
		
		int zadd = x + y;
		int zminus = x - y;
		int ztimes = x * y;
		float xfloat = x;
		float yfloat = y;
		float zdiv = xfloat / yfloat;
		int zmod = x % y;
		
		System.out.println(x + " + " + y + " = " + zadd);
		System.out.println(x + " - " + y + " = " + zminus);
		System.out.println(x + " * " + y + " = " + ztimes);
		System.out.println(x + " / " + y + " = " + zdiv);
		System.out.println(x + " % " + y + " = " + zmod);
	}
}	
