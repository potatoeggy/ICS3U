// Daniel Chen
// 12 September 2019
// Var8

import java.util.Scanner;

class Var8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Investment ($): ");
		float principal = scan.nextFloat();
		
		System.out.print("Interest rate (%): ");
		float rate = scan.nextFloat();
		rate = rate / 100;
		
		System.out.print("Time (Years): ");
		Scanner scan3 = new Scanner(System.in);
		int time = scan.nextInt();
		
		float extraMoney = principal * rate * time;
		float totalMoney = principal + extraMoney;
		
		System.out.println("You earned $" + extraMoney + " in " + time + " year(s), returning a total of $" + totalMoney + ".");
		
		
	}
}	
