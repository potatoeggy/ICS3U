// Daniel Chen
// 28 November 2019
// Read from files

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File; // import required thingies

class IOTestB {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in); // user input
        
        System.out.print("Filename (e.g., file.txt): ");
        Scanner fin = new Scanner(new File(in.nextLine())); // prompt for filename and create new scanner for that file
        
        PrintWriter out = new PrintWriter("fileB.txt"); // setup output
        
        String words = ""; // init blank string
        while (fin.hasNextLine()) {
            words += fin.nextLine() + " "; // add all words to long string separated by space
        } // end while
        
        String[] wordsArray = words.split(" "); // split words into array
        int[] charCount = new int[wordsArray.length]; // create array to hold corresponding character count
        
        char checkChar; // made purely to reduce the amount of words necessary for typing
        
        for (int i = 0; i < wordsArray.length; i++) { // iterate through each word in array
            for (int j = 0; j < wordsArray[i].length(); j++) { // iterate through each character in word
                checkChar = wordsArray[i].charAt(j);
                if (checkChar == 'r' || checkChar == 's' || checkChar == 't' || checkChar == 'n' || checkChar == 'a') {
                    charCount[i]++; // if characters exist increase corresponding count
                } // end if
            } // end j for
        } // end i for
        
        int tempInt; // declare temp variables for bubble sort
        String tempString;
        
        for (int i = 0; i < wordsArray.length - 1; i++) { // bubble sort
            for (int j = 1; j < wordsArray.length - i; j++) {
                if (charCount[j - 1] < charCount[j]) {
                    tempInt = charCount[j - 1]; // swap for both arrays since they're linked
                    charCount[j - 1] = charCount[j];
                    charCount[j] = tempInt;
                    
                    tempString = wordsArray[j - 1];
                    wordsArray[j - 1] = wordsArray[j];
                    wordsArray[j] = tempString;
                }
            }
        }
        
        for (int i = 0; i < wordsArray.length; i++) {
            System.out.println(wordsArray[i] + " - " + charCount[i] + " occurrence(s)"); // print out sorted array
            out.println(wordsArray[i] + " "); // output sorted array
        }
        
        in.close();
        fin.close();
        out.close(); // close file handles
    }
}
