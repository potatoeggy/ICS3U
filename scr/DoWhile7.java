// Daniel Chen
// 26 September 2019
// Word guessing but with statistics and repeated guessing

// Be able to get input from user 
import java.util.Scanner;

class DoWhile7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Initialise required variables
		boolean repeat = true;
		int chipbags = 0;
		String repeattemp;
		do {
			System.out.print("Chip bags: ");
			chipbags += input.nextInt();
			System.out.println("You bought " + chipbags + " chip bags at a cost of $" + (float)chipbags * 1.25 + ". Would you like to buy more chip bags? (Y/n)");
			// Handle repeating the loop
			repeattemp = "" + input.next().charAt(0);
			if ("n".equalsIgnoreCase(repeattemp)) {
				repeat = false;
			}
		} while (repeat);
	}
}

