// CS 1050 - This file contains selected answers to Sample Exam 3
// It is mostly undocumented to help readers educate themselves
// on deciphering code. This version runs on versions earlier than Java 7

import java.util.Scanner;
import java.io.*;  

public class CS1050_Sample_Exam_3_Answers {

   final static int MAX_ENTRIES = 10;   // Max # of entries for arrays
   final static String TAB = "\t";      // Tab character
   final static int FILLER = -999999;   // Used to fill to 3 outIt parameters
   final static String PREFIX1 = TAB;   // Prefix for answers in the output routines
   final static String PREFIX2 = TAB;
   final static String PREFIX3 = TAB;
   final static String PREFIX4 = TAB;

  public static void main(String[] args) throws IOException {   
      String outputLine;                      // Display or output a line
      
      System.out.println("Qn\t#1\t#2\t#3\t#4\n" +
                         "______\t______\t______\t______\t______");

  /* 1.
  
      8 pts.	Write a program segment to initialize each element of the array nums
      to 1.0, given 
         double [][] nums = new double [9][6];
  */   
  
      final int NROWS1 = 9;    // Number of rows
      final int NCOLS1 = 6;    // Number of columns
      double [][] nums1 = new double [NROWS1][NCOLS1]; // Define our array
      
      for (int row = 0; row < NROWS1; row++) {
         for (int col = 0; col < NCOLS1; col++) {
            nums1[row][col] = 1.0;
         }
      }

   // *********************************************************

   /* 2.
  
      16 pts.	Write a method to input numbers, one per line, into the array M
      until the end of file or the array is filled. Note that your method must 
      limit the input array to a certain maximum value. Additionally:
      a. The number of lines read should be returned by the method.
      b. The array M and the input file fileIn are parameters to the method.
         That is, the calling program has the lines:
            File inputFileName = new File(“CS1050_SE3_Q2_Input.txt”);
            Scanner fileIn = new Scanner(inputFileName);
            int[] M;
   */   
      int nNumbers;                    // Length of the (partially) filled array
      int[] M = new int[MAX_ENTRIES];  // Array to fill
      int len2 = M.length;             // Length of the array
      File inputFileName = new File("CS1050_Sample_Exam_3_Q2_Input.txt");
      Scanner fileIn = new Scanner(inputFileName);
      
      M = fillErUpInt(len2,1);         // Avoid "uninitialized" compiler message
      
      nNumbers = SE3Q2(fileIn,M);
      outIt("int","2",nNumbers,M[0],M[1],M[2]);

   // *********************************************************

   /* 3.

      15 pts.	Write a method findAvg to return the average of the values of 
      The array A and the length N should be parameters. Assume:
            double [] A; int N;
   */
   
      double[] A = new double[MAX_ENTRIES];
      int len3 = A.length;                // This is 'N' in the above spec
      double arrayAverage;
      
      A = fillErUpDouble(len3,1.0);       // Avoid "uninitialized" compiler message
      arrayAverage = findAvg(A,len3);     // Calculate the average
      outIt("double","3",arrayAverage,len2,FILLER);

   // *********************************************************

   /* 4.

      15 pts.	Write a method findLargest to return the largest value in the array B.
      Use the array B as a parameter to the method.
         int [] B;
   */

      int[] B4 = new int[MAX_ENTRIES];  // Array to fill
      int len4 = B4.length;             // Length of the array
      int largest4;                     // Largest value in the array
      
      B4 = fillErUpInt(len4,1);         // Avoid "uninitialized" compiler message
      B4[len4/2] = B4[len4/2] * 100;    // Fudge a large number in the middle entry :)
      
      largest4 = findLargest(B4);
      outIt("int","4",largest4, B4[0], B4[1], B4[2]);
      
   // *********************************************************

   /* 5.
   
      16 pts.	Write a method inside a class (that does not have a main program).
      The method will contain a for loop that prints on one line to the screen only 
      for elements in an array named 'list' that are > 0 and corresponding array of 
      names 'name'. (i.e., name[i] has the name of the corresponding to list[i].) It
      will also calculate the real average only of those values of 'list' that are > 0.
      Then print on the last line (after the for loop), as appropriate, the value of 
      the average and the number of elements > 0, or a message indicating there are 
      no elements in 'list' that are > 0. Assume:
      
      public class Sample {
         private double average;
         private int[] list;	   // A list of numbers, some might be > 0
         private String[] name; 	// A list of names corresponding to list
 	      private int num;		   // The number of elements in the arrays
	   
         Your method goes here. Assume the Constructor loaded the arrays
      } // End class
   */

      int[]list5 = new int[MAX_ENTRIES];
      String[] name5 = new String[MAX_ENTRIES];
      int len5 = list5.length;             // Length of the array

      // Initialize the arrays for question 5
      for (int i = 0; i < len5; i++) {
         list5[i] = i - 1;                // Assign some negative numbers
         name5[i] = "Name " + i;
      }
      outIt("int","5",list5[0],list5[1],list5[2],list5[3]);
      displayListQ5(list5, name5);   
      
   // *********************************************************

   /* 6.

      See file CS1050_Sample_Exam_3_Answers_Q6.java for the spec
      and answer for question 6 (which calls for a complete program)
      
   */   
   
  } // End of the Main Program ********************************
            
   // *********************************************************
   // *********************************************************

   // Method for Problem 2 - SE3Q2
   
   public static int SE3Q2(Scanner inp, int[] fillIt) {
      final int MAX_ELEMENTS = MAX_ENTRIES;  // Use a local maximum value
      int numbersRead = 0;                   // Count # of numbers read
      while (inp.hasNext() && (numbersRead < MAX_ELEMENTS)) {
         fillIt[numbersRead] = inp.nextInt();   // Read next number into the array
         numbersRead++;                         // Update number count
    } // End while
         
      // Return the number of elements read which is <= MAX_ELEMENTS.
      // If the input file is empty, the method returns 0.
      return numbersRead;
   }

   // *********************************************************

   // Method for Problem 3 - findAvg
   
   public static double findAvg(double[] A, int len) {
      double theAverage = 0;  // In case the len is 0
      double total = 0;       // Accumulator for the average
      
      for (int i = 0; i < len; i++) {
         total += A[i];
      } // End for
         
      // Return the average if the len is 0; otherwise return the initialized 0
      if (len >= 1) {
         theAverage = total / len;
      } // End if
      return theAverage;
   } // End findAvg

   // *********************************************************

   // Method for Problem 4 - findLargest
   
   public static int findLargest(int[] B) {
   	int largest = B[0];
      int len = B.length;
      
   	for (int i = 1; i < len; i++) {
         if (B[i] > largest) {  
    		  	largest = B[i];
         } // End if
      } // End for
     return largest;
   } // End findLargest
   
   // *********************************************************

   // Method for Problem 5 - displayListQ5
   
   // The method inside a class will NOT have the "static" keyword or a
   // parameter list. We use "static" and the paremeter list here so the
   // method can be called from the main program in this sample
   // The actual method header in a class would be
   //
   //       public void displayListQ5() {
   
   public static void displayListQ5(int[] list, String[] name) {
      int len = list.length;     // Get the length for the for loop
      int oneEntry;              // One entry in the list
      int plusCount = 0;         // # of entries > 0
      int plusSum = 0;           // Sums entries > 0
      double plusAverage= 0;     // Average of entries > 0
      String strPlusAverage;     // String output for plusAverage
      
      // Scan for values > 0
      for (int i = 0; i < len; i++) {
         oneEntry = list[i];
         if (oneEntry > 0) {
            plusCount++;
            plusSum += oneEntry;
            System.out.println(PREFIX1 + name[i] + "\t" + oneEntry);
         } // End if
      } // End for loop  
      
      // Print summary information
      
      if (plusCount > 0) {
         plusAverage = (double) plusSum / plusCount;
         strPlusAverage = plusAverage + "";  // Convert double to string :)
      }
      else {
         strPlusAverage = "No average because no numbers are > 0";
      } // End if
      System.out.println(PREFIX1 +
                         "Number of elements > 0: " + plusCount + "\n" +
                         PREFIX1 + 
                         "Average of these elements: " + strPlusAverage);
   } // End displayListQ5
 
   // *********************************************************
   
   // Generic overloaded output routine for FOUR double variables
   // with conversion if needed to int or char.
   // The first parameter dscribes the output style and is
   // one of int, char or double. Default is double
   
   // Note how the calling program can supply integer and char 
   // variables because the parameters here are double, so
   // the values are *widening*
   
   public static void outIt(String outStyle, String msg,
                            double a, double b, double c, double d) {

     int  int1,  int2,  int3,  int4;  // To convert double to int
     char char1, char2, char3, char4; // To convert double to char
     int outFlag;                     // To convert a string switch to an integer
     
     // Set outFlag to 1, 2 or 3 depending on whether 
     // outStyle = "int", "char" or (default) "double", respectively
     if      (outStyle == "int")  outFlag = 1;
     else if (outStyle == "char") outFlag = 2;
     else                         outFlag = 3;  // Default to double"
     
      // The outStyle parameter has been changed to outFlag above.
      // It indicates the output format. If int
      // or char is supplied, we have to convert the double parameters
      // to int or char, respectively
      
      switch (outFlag) {
         case (1) :
               int1 = (int) a;
               int2 = (int) b;
               int3 = (int) c;
               int4 = (int) d;
               System.out.println(msg + PREFIX1 + int1 + PREFIX2 + int2 + 
                                        PREFIX3 + int3 + PREFIX4 + int4);
               break;
         
         case (2) :
               char1 = (char) a;
               char2 = (char) b;
               char3 = (char) c;
               char4 = (char) d;               
               System.out.println(msg + PREFIX1 + char1 + PREFIX2 + char2 + 
                                  PREFIX3 + char3 + PREFIX4 + char4);
               break;
 
         case (3) : 
         default :
               System.out.println(msg + PREFIX1 + a + PREFIX2 + b + 
                                  PREFIX3 + c + PREFIX4 + d);
      } // End switch
   } // End of outIt method, 4 parameters
   
   // *********************************************************
   
   /*
      Generic overloaded output routine for THREE double variables
      with conversion if needed to int or char.
      The first parameter dscribes the output style and is
      one of int, char or double. Default is to double
   
      Note how the calling program can supply integer and char 
      variables because the parameters here are double, so
      the values are *widening*
   
      This version also differs from the 4-variable version of outIt
      by checking to see if the third parameter, c, is a FILLER, that
      is equal to the constant FILLER. If it is, nothing is output
      for variable c
      
      This approach was taken to demonstrate that a method can produce
      alternate output based on its input. Here, if the third variable
      is equal to FILLER, nothing is output for it. Another choise is to
      write another overloaded outIt method with two parameters
   */
   
   public static void outIt(String outStyle, String msg,
                            double a, double b, double c) {
      int  int1,  int2,  int3;  // To convert double to int
      char char1, char2, char3; // To convert double to char
      String parameter3;        // Build a string for the 3rd parameter
      int outFlag;                     // To convert a string switch to an integer
     
      // Set outFlag to 1, 2 or 3 depending on whether 
      // outStyle = "int", "char" or (default) "double", respectively
      if      (outStyle == "int")  outFlag = 1;
      else if (outStyle == "char") outFlag = 2;
      else                         outFlag = 3;  // Default to double"
     
      // The outStyle parameter has been changed to outFlag above.
      // It indicates the output format. If int
      // or char is supplied, we have to convert the double parameters
      // to int or char, respectively
      
      switch (outFlag) {
         case 1  : 
               int1 = (int) a;
               int2 = (int) b;
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + (int) c;
               System.out.println(msg + PREFIX1 + int1 + PREFIX2 + int2 + 
                                  parameter3);
               break;
         
         case 2  :
               char1 = (char) a;
               char2 = (char) b;
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + (char) c;
               System.out.println(msg + PREFIX1 + char1 + PREFIX2 + char2 + 
                                  parameter3);
               break;
 
         case 3  : 
         default :
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + c;
         
               System.out.println(msg + PREFIX1 + a + PREFIX2 + b + 
                                  parameter3);
      } // End switch
   } // End outIt method, 3 parameters
 
   
   // *********************************************************
   
   // outItArray - Output two same-sized arrays side-by-side
   
   public static void outItArray(String msg,
                                 double[] array1, double[] array2) {
      int len1 = array1.length;  // Get the array lengths to compare them
      int len2 = array2.length;
      
      if (len1 != len2) {
         System.out.println("\n" + msg + "  " +
            "The lengths of the two arrays, " + len1 + " and " + 
            len2 + ", are not the same. No output generated.");
         return;
      }
      
      // Display the arrays
      
      System.out.println(
               "\n" + msg + TAB + "Array 1\tArray 2\n" +
                            TAB + "_______\t_______");
      for (int i = 0; i < len1; i++) {
         System.out.println(TAB + array1[i] + "\t" + array2[i]);
      }     
   } // End of outItArray
   
   // *********************************************************
   
   // outItCharArray - Output the results of searching a char array
   
   public static void outItCharArray(
               String msg, char[] array, char value, int index) {
      int len = array.length;    // Get the length of the array for looping
      String displayValue;       // Displays the 'value' as a character
      
      displayValue = "'" + value + "'";
      System.out.print(
            "\n" + msg + TAB + "In the search for " + displayValue + " in array {");
      for (int i = 0; i < len; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.print("},\n" + TAB + "the value " + displayValue + " was ");
      if (index >= 0) System.out.println("found at index " + index + ".");
      else            System.out.println("not found.");
   } // End of outItCharArray

   // *********************************************************
   
   public static int[] fillErUpInt(int len, int value) {
      int[] fillArray = new int[len];
      
      for (int i = 0; i < len; i++) {
         fillArray[i] = value;
      }
      return fillArray;
   }
   
   // *********************************************************
   
   public static double[] fillErUpDouble(int len, double value) {
      double[] fillArray = new double[len];
      
      for (int i = 0; i < len; i++) {
         fillArray[i] = value;
      }
      return fillArray;
   }
   
} // End of class