// Daniel Chen
// 19 November 2019
// Write numbers o the same line

import java.io.*;

class OutFile3 {
	public static void main(String[] args) throws Exception {
		File file = new File("file3");
		PrintWriter output = new PrintWriter(file);
		for (int i = 1; i < 11; i++) {
			output.print(i + " ");
		}
		output.close();
	}
}
