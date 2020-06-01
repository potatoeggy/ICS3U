// Daniel Chen
// 27 November 2019
// Capitalisation

import java.util.Scanner;
import java.io.PrintWriter; // import required things

class IOTestA {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); // setup user input
        PrintWriter output = new PrintWriter("fileA.txt"); // setup file export
        
        String words = ""; // create blank string to add words to
        for (int i = 0; i < 10; i++) {
            System.out.print("Word: ");
            words += input.nextLine() + " "; // add to string
        }
        
        System.out.println();
        System.out.print("Enter 10 more (Y/n)?"); // ask to stop at 10 words
        if (! input.nextLine().equals("n")) {
            for (int i = 10; i < 20; i++) {
                System.out.print("Word: ");
                words += input.nextLine() + " "; // continue adding to string
            }
        }
        
        String[] wordArray = words.split(" "); // split all words to their own array (assuming user wasn't dumb)
        
        for (int i = 0; i < wordArray.length; i++) {
            output.println(firstLast(wordArray[i])); // output to file
        }
        
        input.close();
        output.close(); // close file and input handles
    }
    
    static String firstLast(String string) {
        String start = string.substring(0, 1).toLowerCase(); // change first letter to lowercase
        String total = start; // pretty make sense variable names
        if (string.length() > 1) { // to prevent crashing
            if (string.length() > 2) { // to prevent crashing
                total += string.substring(1, string.length() - 1).toUpperCase(); // add middle
            }
            total += string.substring(string.length() - 1).toLowerCase(); // add end
        }
        return total; // return to main
    }
}