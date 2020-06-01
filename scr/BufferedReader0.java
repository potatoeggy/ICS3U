// Daniel Chen
// 17 October 2019
// Testing BufferedReader vs Scanner

import java.io.BufferedReader;
import java.io.InputStreamReader;

class BufferedReader0 {
	public static void main(String args[]) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter stuffs");
		try {
			String s = input.readLine(); // these are outside scope
			int i = Integer.parseInt(s);
			System.out.println(i);
		} catch (Exception e) {
			
		}
	}
}
