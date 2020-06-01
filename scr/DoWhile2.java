// Daniel Chen
// 26 September 2019
// While2 clone

// Be able to get input from user 
import java.util.Scanner;

class DoWhile2 {
	public static void main(String[] args) {
		// Initialise counter variable in place of for loop
		int counter = 0;
		do {
			System.out.println(counter);
			counter++;
		} while (counter <= 99);
	}
}
