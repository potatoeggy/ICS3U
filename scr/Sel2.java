// Daniel Chen
// 17 September 2019
// Ask for a mark.  If the mark is >= 50, state “you passed”. If the mark is < 50, say “sorry you failed”. 

import java.util.Scanner;

class Sel2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Mark: ");
		float num = input.nextFloat();
		if (num >= 50) {
			System.out.println("you passed");
		} else {
			System.out.println("sorry you failed");
			
		}
	}
}
