// Daniel Chen
// 22 November 2019
// Reading from a file

import java.util.Scanner;
import java.io.*;

class IOFormativeB {
    public static void main(String[] args) throws Exception {
        
        File file = new File("formativeB.txt"); // setup file output
        PrintWriter output = new PrintWriter(file);
        
        Scanner finput = new Scanner(new File("formative.txt")); // setup file input
        String tempholder = "";
        
        while (finput.hasNext()) {
            tempholder += finput.next() + "\n"; // add everything to one long string just in case input is over five lines long
        }
        String[] wArray = tempholder.split("\n"); // put into array
        
        int eees = 0; // init holding var
        for (int i = 0; i < wArray.length; i++) { // loop through every char
            for (int j = 0; j < wArray[i].length(); j++) {
                if (wArray[i].charAt(j) == 'e' || wArray[i].charAt(j) == 'E') {
                    eees++;
                }
            }
        }
        System.out.println("There is/are " + eees + " of the fifth letter of the English alphabet present.");
        
        String tempString;
        for (int i = 0; i < wArray.length - 1; i++) { // bubble sort
            for (int j = 1; j < wArray.length - i; j++) {
                if (wArray[j - 1].compareTo(wArray[j]) > 0) {
                    tempString = wArray[j - 1];
                    wArray[j - 1] = wArray[j];
                    wArray[j] = tempString;
                }
            }
        }
        
        for (int i = 0; i < wArray.length; i++) { // print sorted array to file
            output.println(wArray[i]);
        } // end for
        
        output.close(); // close file handles
        finput.close();
        
    } // end main
} // end class