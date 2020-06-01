// Daniel Chen
// 24 September 2019
// While3 clone

// Be able to get input from user 
import java.util.Scanner;

class DoWhile3 {
	public static void main(String[] args) {
		// Initialise counter variable in place of for loop
		int counter = 0;
		do {
			System.out.println(counter);
			counter++;
		} while (counter <= 99);
		do {
			System.out.println(counter);
			counter--;			
		} while (counter >= 0);
	}
}
