// Daniel Chen
// 22 November 2019
// Writing to a file

import java.util.Scanner;
import java.io.*;

class IOFormativeA {
    public static void main(String[] args) throws Exception {
        
        File file = new File("formativeA.txt"); // setup file output
        PrintWriter output = new PrintWriter(file);
        
        Scanner input = new Scanner(System.in); // setup input
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Name: ");
            output.println(input.nextLine()); // output to file
        } // end for
        output.close();
        input.close();
    } // end main
} // end class