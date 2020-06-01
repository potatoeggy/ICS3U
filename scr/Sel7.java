// Daniel Chen
// 17 September 2019
// Guess password

import java.util.Scanner;
// Import module for interactivity

class Sel7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Set up interactivity
		System.out.print("Password: ");
		String passwd = input.nextLine();
		// Grab password
		if (passwd.equals("happy")) { // Make decision based on above input
			System.out.println("you are logged in");
		} else {
			System.out.println("incorrect password");
			
		}
	}
}
