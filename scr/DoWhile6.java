// Daniel Chen
// 26 September 2019
// While5 clone 2

// Be able to get input from user 
import java.util.Scanner;

class DoWhile6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Ask for input nicely user friendly-y
		System.out.print("Word: ");
		String word = input.nextLine();
		
		System.out.print("Times: ");
		int repeat = input.nextInt();
		
		// Initialise counter variable in place of for loop
		int counter = 1;
		do {
			System.out.println(word);
			counter++;		
		} while (counter <= repeat);
	}
}
