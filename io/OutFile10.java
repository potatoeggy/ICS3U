// Daniel Chen
// 19 November 2019
// Password and username to file

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class OutFile10 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		File file = new File("file10");
		PrintWriter output = new PrintWriter(file);
		String passwd = "happy";
		String username = "happy";
		
		while (true) {
			System.out.print("Username: ");
			username = input.nextLine();
			if (username.equals("quit")) {
				break;
			}
			
			System.out.print("Password: ");
			passwd = input.nextLine();
			
			if (passwd.equals("happy")) {
				output.println(username);
			}
		}
		
		output.close();
	}
}
