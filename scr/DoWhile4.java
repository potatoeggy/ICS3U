// Daniel Chen
// 26 September 2019
// While4 clone

// Be able to get input from user 
import java.util.Scanner;

class DoWhile4 {
	public static void main(String[] args) {
		// Initialise counter variable in place of for loop
		int counter = 1;
		do {
			System.out.println(counter + ". Daniel");
			counter++;		
		} while (counter <= 10);
	}
}
