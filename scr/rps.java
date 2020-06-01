// Daniel Chen
// 4 October 2019
// Rock paper scissors

import java.util.Scanner;
import java.lang.Math;

class rps {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int userInput;
		int compInput;
		int score = 0;
		String ynhandler;
		System.out.println("Enter 1 for rock, 2 for paper, and 3 for scissors.");
		while (true) {
			System.out.print("Rock, paper, or scissors? (1/2/3) ");
			userInput = input.nextInt();
			compInput = (int) (Math.random() * 3 + 1);
			
			// Tell user what they used
			if (userInput == 1) {
				System.out.println("You used rock!");
			} else if (userInput == 2) {
				System.out.println("You used paper!");
			} else if (userInput == 3) {
				System.out.println("You used scissor!");
			} else {
				System.out.println("You broke the game!");
				break;
			}
			
			// Tell user what computer used
			if (compInput == 1) {
				System.out.println("Computer used rock!");
			} else if (compInput == 2) {
				System.out.println("Computer used paper!");
			} else {
				System.out.println("Computer used scissor!");
			}
			
			if (compInput == userInput) { // no need to check exact because ties 
				System.out.println("It doesn't affect foe PLAYER/COMPUTER... Tie!");
			} else if (compInput - userInput == 1 || compInput - userInput == -2) { // this handles all computer win scenarios because math is cool
				System.out.println("It's not very effective... PLAYER fainted! Player lost!");
			} else {
				System.out.println("It's super effective! COMPUTER fainted! You win!"); // because we don't need to handle dumb users
				score += 1;
			}
			System.out.print("Play again? (Y/n)");
			ynhandler = input.nextLine(); //there are two of these because Java doesn't understand things
			ynhandler = input.nextLine();
			if (ynhandler.equals("n")) {
				System.out.println("You won " + score + " time(s).");
				break;
			
			}
		}	
	}
}		
