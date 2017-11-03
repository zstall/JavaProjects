/* CS 1050 - This file contains answers to Sample Exam 2.
   It is mostly undocumented to help readers educate themselves
   on deciphering code. This version runs on versions earlier than Java 7
   
   NOTE! There are several occurrences of an overloaded method called 
   outIt. They were developed to keep a uniformity of output based on 
   different inputs.
*/

import java.util.Scanner;  // For question 17

public class CS1050_Sample_Exam_2_Answers {
  final static String TAB = "\t";       // Tab character
  final static int FILLER = -999999;    // Used to fill to 3 outIt parameters
  final static String PREFIX1 = TAB;    // Prefix for answers in the output routines
  final static String PREFIX2 = TAB;
  final static String PREFIX3 = TAB;
  final static String PREFIX4 = TAB;

  public static void main(String[] args) {   
   System.out.println("Qn\t#1\t#2\t#3\t#4\n" +
                      "______\t______\t______\t______\t______");
     
   // 1.
   final int c = 2;
   int a = 5; double s = 4.0;
   s = a/c; a -= c;
   outIt("double","1", a, s, c);
   
   // 2.
   int a2 = 1, b2 = 0, c2 = 3;
   if ((c2 == 4) && (c2 ==(2 + a2++)))
      b2 = 5; else b2 = 8;
   outIt("int","2", a2, b2, c2);
   
   // 3.
   int a3 = 1, b3 = 0, c3 = 3;
   if ((c3 != 0) || (c3 == (2 + a3++)))
      b3 = 5; else b3 = 8;
   outIt("int","3", a3, b3, c3);
   
   // 4.
   int h, n, s4, y; char ch;
   
   // 4a.
   h = 0; n = 0; s4 = 0; y = 0;  // Reset variables to initial values
   ch = 'k';
   switch (ch) {  case 'k' : ++h; break; 
                  case 'p' : ++n;
                  case 's' : ++s4;
                  default  : ++y;   }
   outIt("int","4a "+ch, h, n, s4, y);
  
   // 4b.
   h = 0; n = 0; s4 = 0; y = 0;  // Reset variables to initial values
   ch = 'p';
   switch (ch) {  case 'k' : ++h; break;
                  case 'p' : ++n;
                  case 's' : ++s4;
                  default  : ++y;   }
   outIt("int","4b "+ch, h, n, s4, y);
  
   // 4c.
   h = 0; n = 0; s4 = 0; y = 0;  // Reset variables to initial values
   ch = 's';
   switch (ch) {  case 'k' : ++h; break;
                  case 'p' : ++n;
                  case 's' : ++s4;
                  default  : ++y;   }
   outIt("int","4c "+ch, h, n, s4, y);
  
   // 4d.
   h = 0; n = 0; s4 = 0; y = 0;  // Reset variables to initial values
   ch = 'h';
   switch (ch) {  case 'k' : ++h; break;
                  case 'p' : ++n; 
                  case 's' : ++s4;
                  default  : ++y;   }
   outIt("int","4d "+ch, h, n, s4, y);
  
   // 5.
   int [] d = {6, 8, 4};
   outIt("int","5",d[0],d[1],d[2]);
   System.out.println(TAB + "d[3] and d[4] are undefined.");

   // 6.
   char [] t = {'H', 'e', 'n'};
   outIt("char","6",t[0],t[1],t[2]);  
   System.out.println(TAB + "t[3] and t[4] are undefined.");
  
   // 7.
   /* Commented out to avoid compiler errors 
      public class Nums {
         private int num1, num2;
         public double getAverage() {           // Note: No 'static'
            return (double) (num1 + num2) / 2.0;
         }
      }
   */
   
   // 8.
   int a8 = 4, d8 = 3;
   do {a8 *= 2; d8--;}
      while (d8 > 3);
   outIt("int","8",a8,d8);
   
   // 9.
   int a9 = 10, b9 = 1;
   for (; b9 < 10; )
   { b9 += 4; a9 -= 2; }
   outIt("int","9",a9,b9);

   
   // 10.
   int a10 = 3, b10 = 0, c10 = 1;
   for (c10 = 4; c10 < 10; c10 += 2, b10 += a10);
   outIt("int","10",a10, b10, c10);
   
   // 11.
   int c11 = 8, d11 = 7;
   while (d11 > 3)
   { --d11; c11 += 2;}
   outIt("int","11",c11, d11);

     
   // 12.
   int  a12 = 0, b12 = 8, s12 = 1;
   for (b12 = 0, a12 = 5; a12 > 1; --a12)
      { if (a12 == 3) break;
        s12 = a12; b12++; }
   outIt("int","12",a12, b12, s12);
   
   // 13.
   int  a13 = 0, b13 = 8, s13 = 1;
   for (b13 = 0, a13 = 5; a13 > 1; --a13)
   { if(a13 == 3) continue;
        s13 = a13; b13++; }
   outIt("int","13",a13, b13, s13);      

   // 14.   See the methods shiftChar and shifCharMuchMoreGeneral below
   char a14 = 'A', b14 = 'a';
   char m14 = 'm', n14 = 'M';
   char y14 = 'Z', z14 = 'z';
   outIt("char","14 A", a14, shiftChar(a14), b14, shiftChar(b14));
   outIt("char","14 B", m14, shiftChar(m14), n14, shiftChar(n14));
   outIt("char","14 C", y14, shiftCharMuchMoreGeneral(y14), 
                        z14, shiftCharMuchMoreGeneral(z14));
   
   // 15.   See the method halveOrNothing below
   //       outItArray is defined in the "outIt" methods area
   
   double[] dNum = {1.0, -2.0, 3.5, -4.2, 5.0};      // #s to double
   double[] dNumHalved = new double[dNum.length];    // Halved #s
   
   dNumHalved = halveOrNothing(dNum);
   outItArray("15", dNum, dNumHalved);
   
   // 16.   See the method searchForValue below
   //       outItCharArray is defined in the "outIt" methods area
   
   // Note: the sample exam question uses variable "d" for the array name;
   // we're using "ch16" instead to avoid double declarations. Also,
   // variable "t" is replaced by "t16a" and "t16b"
   
   char[] ch16 = {'a', 'b', 'C', 'D', '+'};  // Define the array to search
   int sub;                                  // Subscript of found value
   char t16a = 'D';                          // Value in the array
   char t16b = 'Q';                          // Value not in the array
   
   sub = searchForValue(ch16, t16a);
   outItCharArray("16 " + t16a, ch16, t16a, sub);
   sub = searchForValue(ch16, t16b);
   outItCharArray("16 " + t16b, ch16, t16b, sub);
   
   // 17. Calculate reimbursement
   
   // NOTE! The sample problem calls for a complete program. It is written
   // here as a method so it can be included in the answer file.
   // See the method itself further down the page.
   
   calculateReimbursement();
   
  } // end main
  
   // ********************* METHODS **************************  
            
   // *********************************************************

   // Question 14's method, shiftChar

   public static char shiftChar(char oneChar) {
      if (oneChar >= 'A' && oneChar <= 'Z')
          oneChar++; // Note that oneChar = oneChar + 1 gives a compiler error!
      return oneChar;
   } // end shiftChar

    // *********************************************************

   // Question 14's second method, shiftCharMuchMoreGeneral

   /*
    * This method is much more general than shiftChar because:
    *  
    * Instead of the "+ 1" inside the 'if' statement, code any other number
    * to shift left or right. For example, to shift right 10 characters,
    * simply change the "+ 1" to "+ 10". Or, to shift left three characters,
    * change the "+ 1" to "- 3"
    *
    * To shift, say, three to the left using the decrement operator, one
    * would have to code   --oneChar;     three times. This gets unwieldy 
    * if you want to shift 20 or 300 characters! Or, you could code a for
    * loop like this:
    *
    * The method words by casting the charater into an integer, adding to
    * subtracting the desired shift, then casting it back to a character.
    */
    
   public static char shiftCharMuchMoreGeneral(char oneChar) {
      if (oneChar >= 'A' && oneChar <= 'Z')
         // Instead of    oneChar++;     as inthe above shiftChar method:
         oneChar = (char) ( (int) oneChar + 1 );
      return oneChar;
   } // end shiftChar

   // *********************************************************

   // Question 15's method, halveOrNothing: double an array's elements
   
   // Define a local array to receive the doubled numbers and return it
   
   public static double[] halveOrNothing(double[] array) {
      int len = array.length;                      // We'll need the array length
      double[] doubledNumbers = new double[len];   // Define the local array
      
      for (int i = 0; i < len; i++) {
         doubledNumbers[i] = array[i] / 2.0;
      }
      
      return doubledNumbers;
   } // end halveOrNothing
  
   // *********************************************************
   
   // Question 16's method, searchForValue: search an array for a value
   
   public static int searchForValue(char[] array, char value) {
      int len = array.length;    // Get the array length for looping
      int element = -1;          // -1 means "value not found"
      
      for (int i = 0; i < len; i++) {
         if (array[i] == value) {
            element = i;
            break;
         }
      }
      
      return element;   // -1 or the index from 0 to len    
   } // end searchForValue

   // *********************************************************
   
   // Question 17's method, calculateReimbursement
   
   // Note that for the complete program, wrap a class around the 
   // method with a Java class name and appropriate {...}'s.
   // Change the method header to
   //    public static void main(String[] args)
   
   public static void calculateReimbursement() {
      // Declarations
      
      int n;                   // Number of mileage values to process
      double mileage;          // A mileage value to input
      double reimb;            // Reimbursement amount for one mileage value
      double base;             // Base amount for a reimbursement
      double rate;             // Rate per mile to reimburse
      double overage;          // Mileage overage on which to calculate rate per mile
      
      double mileageTotal = 0; // Total mileage for input mileages > 0
      double reimbTotal = 0;   // Total reimbursement dollar amount
      int mileagePositive = 0; // Number of mileage values > 0
      
      Scanner keyboard = new Scanner(System.in);   // Assign keyboard input
      
      // Get the number of mileage values to process
      
      System.out.print(
            "Enter the number of mileage values to process (0 to exit): ");  
      n = keyboard.nextInt();
      if (n <= 0) {
         System.out.println("Have a great day!");
         System.exit(0);
      }
      
       // Get n mileage values, calculate reimbursements and totals and
       // print the mileage and reimbursement amounts or "****"
      
      for (int i = 1; i <= n; i++) {
         System.out.print("Enter mileage value #" + i + " of " + n + ": ");
         mileage = keyboard.nextDouble();
         
         // Display the mileage value whether <= 0 or > 0
         System.out.print("Mileage: " + mileage + "\tReimbursement: ");   
         if (mileage <=0 ) {
            System.out.println("****");   // Print just the stars and...
            continue;                     // move on to the next mileage value
         }
         else if (mileage <=  500) {base =   0; rate = 0.15; overage = mileage;}
         else if (mileage <= 1000) {base =  75; rate = 0.12; overage = mileage -  500;}
         else if (mileage <= 2000) {base = 135; rate = 0.10; overage = mileage - 1000;}
         else                      {base = 235; rate = 0.08; overage = mileage - 2000;}

         // Calculate and print the reimbursement amount and caclculate running totals
         
         reimb = base + (rate * overage);
         mileageTotal += mileage;
         reimbTotal += reimb;
         mileagePositive++;
         System.out.println(reimb); // Note that the mileage has already been printed
      } // End of for loop(int i...)
      
      // Output the totals, leaving a blank line before the messages
      
      System.out.println(
         "\nNumber of positive mileage values processed: " + mileagePositive +
               " of " + n + " values input.\n" +
         "Total mileage: " +  mileageTotal + "\n" +
         "Total reimbursement: " + reimbTotal);
         
   } // end calculateReimbursement

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
     String oneLine = "";             // Build a line to output
          
     // Set outFlag to 1, 2 or 3 depending on whether the parameter
     // outStyle = "int", "char" or (default) "double", respectively.
     // This is done to accommodate Java versions before 7
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
               oneLine = msg + PREFIX1 + int1 + PREFIX2 + int2 + 
                               PREFIX3 + int3 + PREFIX4 + int4;
               break;
         
         case (2) :
               char1 = (char) a;
               char2 = (char) b;
               char3 = (char) c;
               char4 = (char) d; 
               oneLine = msg + PREFIX1 + char1 + PREFIX2 + char2 + 
                               PREFIX3 + char3 + PREFIX4 + char4;              
               break;
 
         case (3) : 
         default  :
               oneLine = msg + PREFIX1 + a + PREFIX2 + b + 
                               PREFIX3 + c + PREFIX4 + d;
      } // End switch (outFlag)
      
      System.out.println(oneLine);  // Display the output on the screen
      
   } // end outIt method, 4 parameters
   
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
      int outFlag;              // To convert a string switch to an integer
      String oneLine = "";      // Build a line to output
          
      // Set outFlag to 1, 2 or 3 depending on whether the parameter
      // outStyle = "int", "char" or (default) "double", respectively.
      // This is done to accommodate Java versions before 7
     
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
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + (int) c;
               oneLine = msg + PREFIX1 + int1 + PREFIX2 + int2 + parameter3;
               break;
         
         case (2) :
               char1 = (char) a;
               char2 = (char) b;
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + (char) c;
               oneLine = msg + PREFIX1 + char1 + PREFIX2 + char2 + parameter3               ;
               break;
 
         case (3) : 
         default  :
               if (c == FILLER) parameter3 = "";
               else             parameter3 = PREFIX3 + c;
         
               oneLine = msg + PREFIX1 + a + PREFIX2 + b + parameter3;
                                  
      } // End switch (outFlag)
      
      System.out.println(oneLine);  // Display the output on the screen
         
   } // end outIt method, 3 parameters
 
   
   // *********************************************************
   
   /*
      Generic overloaded output routine for variables in this order:
      int, double, int.
         */
   
   public static void outIt(String outStyle, String msg,
                            int int1, double double1, int int2) {
      String oneLine = "";      // Build a line to output
          
      oneLine = msg + PREFIX1 + int1 + PREFIX2 + double1 + PREFIX3 + int2;
      System.out.println(oneLine);  // Display the output on the screen
         
   } // end outIt method, 3 parameters

   // *********************************************************
   
   /*
      Generic overloaded output routine for two integers:
      int, int.
         */
   
   public static void outIt(String outStyle, String msg,
                            int int1, int int2) {
      String oneLine = "";      // Build a line to output
          
      oneLine = msg + PREFIX1 + int1 + PREFIX2 + int2;
      System.out.println(oneLine);  // Display the output on the screen
         
   } // end outIt method, 2 integer parameters
   
   // *********************************************************
   
   /*
      Generic overloaded output routine for three integers:
      int, int, int
         */
   
   public static void outIt(String outStyle, String msg,
                            int int1, int int2, int int3) {
      String oneLine = "";      // Build a line to output
          
      oneLine = msg + PREFIX1 + int1 + PREFIX2 + int2 + PREFIX3 + int3;
      System.out.println(oneLine);  // Display the output on the screen
         
   } // end outIt method, 2 integer parameters
   
   // *********************************************************
   
   /*
      Generic overloaded output routine for char, char, char
         */
   
   public static void outIt(String outStyle, String msg,
                            char char1, char char2, char char3) {
      String oneLine = "";      // Build a line to output
          
      oneLine = msg + PREFIX1 + char1 + PREFIX2 + char2 + 
                      PREFIX3 + char3;
      System.out.println(oneLine);  // Display the output on the screen
         
   } // end outIt method, 2 integer parameters
   
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
   } // end outItArray
   
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
   } // end outItCharArray
} // end class