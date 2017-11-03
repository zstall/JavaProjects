/* Sum and Average ArrayList Entries

   This program will read integer values from the console
   and add the value to an array list until the user inputs
   a zero.
   
   After zero is pressed, the program will calculate the 
   total number of values entered, calculate the average of
   the values entered, and will output these values to the 
   console.
   
   Zachary Stall 
   Program #11, CS 1050, Section 2
   JGrasp, Custom PC, Windows 10
   
   Redact - Edit somthing: to edit, revise, or delete content
   in preparation for publication.
   
   "A friendship founded on business is better than a business founded
   on friendship."
   -John D. Rockefeller (July 1839 - May 1937)

*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ZacharyStall_2_11 {
   
   // Establish tools to format average
   static Toolkit tools = new Toolkit();
   // Establish console to get numbers from user
   static Scanner console = new Scanner(System.in);
   
   public static void main (String [] args) {
   
   
      int oneNumber;             // To get values from console
      int total = 0;             // Number of values processed
      int sum = 0;               // Sum of all numbers entered
      boolean error = false;     // To make sure integers are input
   
      double avgNumbers = 0.0;   // Average of numbers entered
   
      // The ArrayList to store all numbers
      ArrayList<Integer> theList = new ArrayList<Integer>();  
      
      // Start program and promtp user
      System.out.println("This program will store the numbers " +
                         "that you enter, \nit will print how " +
                         "many numbers you entered and return " +
                         "the average.\n To exit the program and " +
                         "get your results, press 0.");
      
      // Try/Catch to catch if user puts something other than an
      // integer into the console. If they do program is terminated
      try {
         // Do/while loop, will enter inputs from console to ArrayList
         // until user enters a '0'. do/while loop also totals the numbers
         // input
         do {
            System.out.print ("Number " + (total + 1) + " Enter:");
            oneNumber = console.nextInt();
                 
            if (oneNumber != 0) {
               theList.add(new Integer(oneNumber));
               total++;
            }
         } while (oneNumber != 0); // End do while
      } // End Try      
      catch (InputMismatchException e) {
         
         System.out.println("This Program can only use integer numbers.");
         System.out.println("Program Exit");
         System.exit(0);
      } // End catch
      
      // Calculates the sum of the ArrayList  
      sum = getSum(theList, total);
   
      // Checks that there are inputs to average, if not then program
      // is terminated. If numbers have been entered, average is calculated
      // and total numbers, sum, and average are printed to console.
      if(sum == 0) {
         System.out.println("No numbers to average, program exit.");
         System.exit(0);
      }
      else {
         avgNumbers = (double)sum / total;
         System.out.println("Zero Entered, calculating..." + "\n");
         System.out.println("Total numbers: " + total);
         System.out.println("Sum of all number: " + sum);
         System.out.println("Average: " + tools.leftPad(avgNumbers, 0, "##0.00"));
      }
      
      System.exit(0);
   } // End Main
   
   // Methods
   // ***************************************************   
   // Ask user for inputs
   public static int getSum(ArrayList<Integer> list, int N) {
      int sum = 0;   // var for sum of ArrayList
      
      for (int i = 0; i < N; i++) {
         sum += list.get(i);
         } // End for loop
      
      return sum;   
   } // End getSum 
} // End Class