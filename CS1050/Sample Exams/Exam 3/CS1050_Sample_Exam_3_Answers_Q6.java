// CS 1050 - This file contains the answer to Sample Exam 3, Question 6.
// It is mostly undocumented to help readers educate themselves
// on deciphering code. This version runs on versions earlier than Java 7

import java.util.Scanner;
import java.io.*;  

public class CS1050_Sample_Exam_3_Answers_Q6 {
   final static int MAX_ENTRIES = 10;   // Max # of entries for arrays
   final static String TAB = "\t";      // Tab character
   final static int FILLER = -999999;   // Used to fill to 3 outIt parameters
   final static String PREFIX1 = TAB;   // Prefix for answers in the output routines
   final static String PREFIX2 = TAB;
   final static String PREFIX3 = TAB;
   final static String PREFIX4 = TAB;

  public static void main(String[] args) throws IOException {   
  
      String outputLine;                      // Display or output a line

  /* Question 6.
  
      50 pts.  Write a complete program (including import statements) to do
      the following:
      Each data line contains an integer followed by a space and a name.
      Process input lines until the end of the file.  Create a printed report that
      consists of a table with the words GRADE REPORT as a heading.
      The columns of the report contain the name, the number, and a message. The
      message is:
         GREAT, if the number is 87 or more; 
         Okay, if the number is between 65 and 86 inclusive,
         and Poor otherwise.
      At the bottom of the table, print, with appropriate messages, the number of
      names processed and the number of the values between 65 and 86 inclusive.
      If there are values in that range, print their average and the number of
      values in that range. If not, print a message that there is no average.
      Do not use arrays for storage. Use an if/else if. Comments are not necessary.
      The name of the input file is "Input.txt" and the name of the output file is
      "Output.txt"
  */   
  
      // Declare variables
		// Define your output file name on the next two lines as needed.
		// You may want to use a flash drive letter
      
		final String INPUT_FILE  = "CS1050_Sample_Exam_3_Q6_Input.txt";
		final String OUTPUT_FILE = "CS1050_Sample_Exam_3_Q6_Output.txt";
      
		int numberOfGrades = 0;     // # of grades in the input file
      int rangeCount = 0;         // # of grades between 65 and 86
		double rangeSum = 0;		 	 // The sum of the numbers in that range
		double oneGrade;			    // An individual grade read from the file
      String oneName;             // An individual name read from the file
		String msg = "";	          // Message describing the range
		String strAverage;          // String for the range average or a message
      
		// Access the input/output files
      
		File inputDataFile = new File(INPUT_FILE);
		Scanner inputFile = new Scanner(inputDataFile);
		FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
		PrintWriter outputFile = new PrintWriter(outputDataFile);
  
      // Print the header
      outputFile.println("GRADE REPORT");
      outputFile.println("Name                      Grade      Message\n");
      outputFile.println("___________________________________________");

      while (inputFile.hasNext()) {
         numberOfGrades++;          // Count the total number of names processed
         
         // Get the next line's grade and name
         oneGrade = inputFile.nextInt();
         oneName  = inputFile.nextLine();
         oneName  = oneName.trim();
         
         // Find the slot for the grade and update count and sum if necessary
         if      (oneGrade >= 87) { msg = "GREAT"; }
         else if (oneGrade >= 65) { msg = "Okay"; rangeCount++; rangeSum += oneGrade; }
         else                     { msg = "Poor"; }   
         
         outputFile.println(oneName + "\t" + oneGrade + "\t" +msg);
      } // End while
      
      if (rangeCount > 0) {
         strAverage = (double) rangeSum / rangeCount + "";  // Force string conversion
      }
      else {
         strAverage = "None";
      }
      
      outputFile.println("# of names processed: " + numberOfGrades);
      outputFile.println("# of grades in range 65 to 86: " + rangeCount);
      outputFile.println("Average of grades in this range: " + strAverage);

      // Wrap up loose ends            
      inputFile.close();
      outputFile.close();
      System.exit(0);
  } // End main program
} // End of class