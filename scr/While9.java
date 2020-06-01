// Daniel Chen
// 24 September 2019
// Word guessing but with statistics and repeated guessing

// Be able to get input from user 
import java.util.Scanner;

class While9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Make input user-friendly by telling them what to do
		System.out.print("Word: ");
		String word = input.nextLine();
		
		// Initialise guessing variable
		String guess = "There's no way anyone would possibly guess this it's a completely random string since Java doesn't like having this empty and yeah";
		
		// Initialise counter variable
		int counter = 0;
		while (! word == guess) {
			System.out.print("Guess: ");
			guess = input.nextLine();
			counter++;
		}
		System.out.println("The word was \"" + word + "\".");
		System.out.println("You guessed it in " + counter + " guesses.");
	}
}

