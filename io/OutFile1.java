// Daniel Chen
// 19 November 2019
// Write my name

import java.io.*;

class OutFile1 {
	public static void main(String[] args) throws Exception {
		File file1 = new File("file1");
		PrintWriter output = new PrintWriter(file1);
		output.println("Daniel Chen");
		output.close();
	}
}
