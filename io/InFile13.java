// Daniel Chen
// 19 November 2019
// Read and print file

import java.util.Scanner;
import java.io.File;

class InFile13 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		File file = new File("file10");
		Scanner finput = new Scanner(file);
		System.out.print("Username: ");
		String username = input.nextLine();
		boolean logged_on = false;
		
		while (finput.hasNextLine()) {
			if (finput.nextLine().equals(username)) {
				logged_on = true;
			}
		}
		
		if (logged_on) {
			System.out.println("You are logged on");
		} else {
			System.out.println("You do not have a valid account");
		}
		
		finput.close();
	}
}
