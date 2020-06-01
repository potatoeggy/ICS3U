// Daniel Chen
// 19 November 2019
// Triangles in files

import java.util.Scanner;
import java.io.*;

class OutFile14 {
	public static void main(String[] args) throws Exception {		
		printTree(10);
	}
	
	public static void printTree(int height) throws Exception {
		File file = new File("file14");
		PrintWriter output = new PrintWriter(file);
		for (int i = 1; i < height + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				output.print('*');
			}
				output.println();
		}
		output.close();
	}
}
