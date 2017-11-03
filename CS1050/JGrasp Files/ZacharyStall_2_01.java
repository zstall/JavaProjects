/* Interactive Average Program
   This program asks the user to input two real numbers,
   calculates the average of these numbers, and prints the results
   Zachary Stall
   Program #1, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   Surreptitious - obtained, done, made, by stealth; secret or unauthorized
   "The secret to getting ahead is getting started." Mark Twain (1835 - 1910)
*/

import java.util.Scanner;

public class ZacharyStall_2_01 {

   public static void main (String [] args) {
   
      Scanner console = new Scanner(System.in);
      double num1 = 0.0;            // Input value 1
      double num2 = 0.0;            // Input value 2
      double average = 0.0;         // Average of the input values
      
      //Explaine the program to the user
      System.out.println("This program averages two real numbers.");
      
      //Input the two numbers
      System.out.print("Input your first number: ");
      num1 = console.nextDouble();
      System.out.print("Input your second number: ");
      num2 = console.nextDouble();
      
      //Calculate the average of the two numbers
      average = (num1 + num2)/2.0;
      
      //Output the results
      System.out.print("The average of " + num1);
      System.out.println(" and " + num2 + " is " + average);
      System.out.println("Zachary Stall");
      
      //Close files and exit
      console.close();
      System.exit(0);
   }//End main
}//End class      