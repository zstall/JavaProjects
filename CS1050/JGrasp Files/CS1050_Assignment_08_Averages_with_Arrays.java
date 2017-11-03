/*
   InteractiveAverageArrays - Calculate averages of a set of numbers
   
   This program reads a file of pairs of double values and calculates the
   average of each pair. The numbers are read into two arrays and the
   averages are stored in a third array. At the start of the file,
   however, is the number of pairs that follow.
   
   The purpose of this program is to serve as a model for Assignment 8
   which is the mileage calculation program (Assignment 6) using arrays.
   
   The program is incomplete in that one or more methods are stubs and 
   one or more methods that will be used in Assignment 8 are not coded here.
   
*/

import java.util.Scanner;
import java.io.*;

public class CS1050_Assignment_08_Averages_with_Arrays {

   // Global variables
   static Toolkit tools = new Toolkit();  // Access the Toolkit
   static final int WIDTH = 9;            // # of characters for each output field
   static final String MASK = "0.00";     // Mask for displaying the numbers

   public static void main(String[ ] args) throws IOException {
   
      // Constants
      
      final String INPUT_FILE  = "CS1050_Assignment_08_Input.txt";
      final String OUTPUT_FILE = "CS1050_Assignment_08_Output.txt";

      // Declarations
      
      double[] first;      // First numbers to average
      double[] second;     // Second numbers to average
      double[] averages;   // The parallel array with the average of the first
                           // and second numbers, so
                           // averages[i] = (first[i] + second[i]) / 2.0;
                           
      int nHeaderValue = 0;         // # of entries from start of input
      int nEntries = 0;             // # of entries read from the input file

   	// Access the input/output files
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);

      //***********************************************************************
      
      // Begin program execution
      
      nHeaderValue = inputFile.nextInt();    // Get the number of pairs
      
      // Establish the size of the arrays for the rest of the program.
      first    = new double[nHeaderValue];
      second   = new double[nHeaderValue];
      averages = new double[nHeaderValue];
      
      // Get the pairs of numbers into arrays 'first' and 'second'.Note that
      // this number could be less than the length of the arrays, but it
      // cannot exceed the length.
      nEntries = readData(inputFile, first, second);

      // Ensure the # of pairs read is the same as the number of pairs
      // indicated at the start of the input file.
      
      if (nHeaderValue != nEntries) {
         System.out.println(
            "The # of entries in the input file doesn't match header value." +
            "\nProgram terminated.");
            System.exit(0);
      } // End if
      
      // Calculate the average of each pair of numbers.
      calcAverages(first, second, averages, nEntries);
      
      // Display the values of the first, second and averages arrays.
      displayValues(outputFile, first, second, averages, nEntries);
      
      //***********************************************************************
      
      // End of program housekeeping: close files and exit.
      inputFile.close();
      outputFile.close();
      System.exit(0);
      
   } // End main

   //**************************************************************************
   
   /**
      readData - read the data from the input file into two arrays
      
      @param   input    Scanner object referring to the input file
      @param   array1   The array that receives the first  # of the pair
      @param   array2   The array that receives the second # of the pair
      @return  # of entries read into the arrays
      
      Note that this method does not process pairs of numbers that might
      remain in the input file after the arrays are filled.      
   */
   
   public static int readData(Scanner input, double[] array1, double[] array2) {
   
      int len = array1.length;   // # of pairs expected
      int nRead = 0;             // # of pairs read
      
      while (input.hasNext() && nRead < len) {
         array1[nRead] = input.nextDouble();
         array2[nRead] = input.nextDouble();
         nRead++;
      } // End while
   
      return nRead;
   } // End readData

   //**************************************************************************
   
   /**
      calcAverages - calculate the averages of pairs of numbers
      
      @param   array1    The array with the first  # of the pair
      @param   array2    The array with the second # of the pair
      @param   averages  The averages of the first and second numbers
      @param   nElements The number of elements to process which could be less
                         than the length of the array  
      @return  None  
   */
   
   public static void calcAverages(double[] array1, double[] array2,
                                   double[] averages, int nElements) {
      for (int i = 0; i < nElements; i++) {
         averages[i] = (array1[i] + array2[i]) / 2.0;
      } // End for

   } // End calcAverages
   
   //**************************************************************************
   
   /**
      displayValues - display the numbers and averages

      @param   output    PrintWriter variable that accesses the output file      
      @param   array1    The array with the first  # of the pair
      @param   array2    The array with the second # of the pair
      @param   averages  The averages of the first and second numbers
      @param   nElements The number of elements to process which could be less
                         than the length of the array  
      @return  None  
   */
   
   public static void displayValues(PrintWriter output,
                                    double[] array1, double[] array2,
                                    double[] averages, int nElements) {
      String watermelon = "";       // Prepares a line for output

      displayHeading(output);       // Print a heading to both output areas
            
      for (int i = 0; i < nElements; i++) {
         watermelon = tools.leftPad(array1[i],WIDTH,MASK) + 
                      tools.leftPad(array2[i],WIDTH,MASK) + 
                      tools.leftPad(averages[i],WIDTH,MASK);
         System.out.println(watermelon);
         output.println(watermelon);
      } // End for

   } // End displayValues
   
   //**************************************************************************
   
   /**
      displayHeading - Print the heading for the list of numbers and averages
      
      @param   out   PrintWriter variable to access the output file
      @return  None.
      
      Note: this method is a stub.
   */
   
   public static void displayHeading(PrintWriter out) {
   } // End displayHeading
   
   //**************************************************************************
} // End class