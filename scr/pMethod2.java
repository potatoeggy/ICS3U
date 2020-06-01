// Daniel Chen
// 31 October 2019
// Interest calculator

import java.util.Scanner;

class pMethod2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Balance at beginning of year: ");
		double balance = sc.nextDouble();
		
		System.out.print("Current interest rate: ");
		double currentInterest = sc.nextDouble();
		
		interestBalance(balance, currentInterest);
	}
	public static void interestBalance(double bal, double i) {
		System.out.println("Interest = " + bal * i);
		System.out.println("New balance = " + (bal + bal * i));
	}
}
