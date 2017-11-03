/** File: CS1050_Assignment_04_File_Input_Output_Example.java
    Accompanies Programming Assignment 4

	 Read a file of numbers, calculate sums and averages
	 
	 Input	File YourName_S_04_Input.txt that has double numbers for gross pay,
            savings rate and IRA investment rate, one set per line
	 
	 Process	Read the data values, calculate savings and IRA investment amounts,
            and sum them
	 
	 Output	A file with the original data values, one line for each input line as
            shown in the assignment specification. After the detail lines are
            displayed, leave a blank line then add lines with appropriate
            messages for:
            1. the number of input lines read
            2. the number of valid input lines read (all three input numbers are 
               greater than 0)
            3. the averages of the gross pay, savings amount and IRA investment
               amount, one to a line

            The output file is named YourName_S_04_Output.txt
            
    Note 	Without your added code, the program will display the number
		      of numbers in the input file.

*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

// Change the name of the class to YourName_S_04

public class CS1050_Assignment_04_GrossPayFileInputOutput_Template {

   public static void main(String[] args) throws IOException {
   
      // Declare variables
   	// Define your file names on the next two lines as needed.
      // Replace YourName and use your section # for the "S".
      // Example: JohnSmith_1_04_Input.txt
   
      final String INPUT_FILE  = "YourName_S_04_Input.txt";
      final String OUTPUT_FILE = "YourName_S_04_Output.txt";
      
      int numInputLines = 0;     // Number of lines in the input file
      int numValidLines = 0;     // Number of valid lines in the input file
      double grossPay = 0.0;     // Input file's gross pay
      double savingsRate = 0.0;  // Input file's savings rate
      double iraRate = 0.0;      // Input file's IRA investment rate
      double sumGrossPay = 0.0;  // Sum of all valid gross pay amounts
      double sumSavings = 0.0;   // Sum of all valid savings amounts
      double sumIra = 0.0;       // Sum of all valid IRA investment amounts
//### Add variables to calculate the averages
   	
   	// Access the input/output files
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Begin program execution
      
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");
   	
   	// Read the input file and sum the numbers. 
   	
      while (inputFile.hasNext()) {
         numInputLines++;
         grossPay = inputFile.nextDouble();
         savingsRate = inputFile.nextDouble();
         iraRate = inputFile.nextDouble();
      		//### Add code here to:
            // 1. Calculate savings and IRA investment amounts
            // 2. Add those amounts to running totals
      		// 3. Write the spec'd information to the output file
      		// 4. Write the same information to the console
      		//		(use System.out.println). This is called "Echoing the input"
      } // End while
   
      System.out.println("The number of input lines is " + numInputLines);

      /* 
         //### Here, the while loop has ended, meaning we've read the entire file
   	   Add code here to:
   	   1. Write to the console and the output file the information listed
            in the spec. You'll remove the println command above which is in the 
            template only to show that the program runs from start to end
   	   2. Close the input file
   	   3. Close the output file
         Without your added code, the program will display the number of numbers in
         the input file, and an unformatted sum and average of 0.0
      */
      
      System.exit(0);	
   } // End main
} // End class