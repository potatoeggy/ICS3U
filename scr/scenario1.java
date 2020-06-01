// Daniel Chen
// 17 September 2019
// Various scenarios 

import java.util.Scanner;
// Make it interactive

class Scenario1 {
// If entered age is greater than 65 they're seniors
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Age: ");
		float age = input.nextFloat();
		if (age >= 65) {
			System.out.println("You're old");
		} else {
			System.out.println("You're not old");
		}
	}	
}

class Scenario2 {
// Player is trying to guess number
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Guess number (0-10): ");
		float guessNumber = input.nextFloat();
		if (guessNumber == 2) {
			System.out.println("Yay you got it");
		} else {
			System.out.println("No you bad that's wrong");
		}
	}
}

class Scenario3 {
// If person consumed enough water say yay
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Cups of water consumed: ");
		int waterDrank = input.nextInt();
		if (waterDrank >= 8) {
			System.out.println("You drank enough water");
		} else {
			System.out.println("Drink more water you dumdum");
		}
	}
	
}
