// Daniel Chen
// 19 November 2019
// Write numbers

import java.io.*;

class OutFile2 {
	public static void main(String[] args) throws Exception {
		File file1 = new File("file2");
		PrintWriter output = new PrintWriter(file1);
		for (int i = 1; i < 11; i++) {
			output.println(i);
		}
		output.close();
	}
}
