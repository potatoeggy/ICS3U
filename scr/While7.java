// Daniel Chen
// 24 September 2019
// Count to 10 and output accumulating numbers (each time?)

// Be able to get input from user 
import java.util.Scanner;

class While7 {
	public static void main(String[] args) {
		// Initialise counter variable in place of for loop
		int counter = 1;
		int accumulator = 0;
		while (counter <= 10) {
			System.out.println(counter);
			accumulator += counter;
			System.out.println("Total: " + accumulator);
			counter++;
		}
	}
}
