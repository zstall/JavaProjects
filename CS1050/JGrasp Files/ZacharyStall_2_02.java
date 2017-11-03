/* Gross Pay, Savings, and Investment Calculator
   This program purpose is to calculate gross pay, savings, and investment based
   off of user inputs.
   Zachary Stall
   Program #2, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   Foreboding - fearful apprehension; a feeling that something bad will happen.
   "There is no greater education than one that is self-driven." Neil deGrasse Tyson (1958)
*/

import java.util.Scanner;

public class ZacharyStall_2_02 {

   public static void main (String [] args) {
   
      Scanner console = new Scanner(System.in);
      double grossPay = 0.0;           // Gross Pay
      double savePercent = 0.0;        // Saving rate percentage
      double iraPercent = 0.0;         // IRA investment rate percentage
      double saveAmount = 0.0;         // Amount saved based off of grossPay and savePercent
      double iraAmount = 0.0;          // Amount saved based off of grossPay and iraPervent
      double investTotal = 0.0;        // Total amount invested in savings and ira
      
      //Explain the program to the user
      System.out.println("The user will input gross pay, saving percentage rate, " +
         "and IRA percentage investment rate.");
      System.out.println("Based on the information the program will give a summary " +
         "of the amount that is applied to: \nSavings, IRA, and Total Money Applied" +
         " to Both Accounts.");
            
      //Input the gross pay, the percent saving rate, and the percent invested in IRA rate
      System.out.print("Input gross pay: ");
      grossPay = console.nextDouble();
      System.out.print("Input percent saved (ex. 12% = 12): ");
      savePercent = console.nextDouble();
      System.out.print("Input percent invested in IRA (ex. 8% = 8): ");
      iraPercent = console.nextDouble();
      
      //Calculating the amounts in savings,IRA, and total amount invested
      saveAmount = grossPay * (savePercent / 100);
      iraAmount = grossPay * (iraPercent / 100);
      investTotal = saveAmount + iraAmount;
      
      //Returns to seperate user inputs and program outputs
      System.out.println();
      System.out.println();
      
      //Output the results
      System.out.println("Gross pay entered: $" + grossPay);
      System.out.println("Percentage applied to savings: " + savePercent + "%"); 
      System.out.println("Percentage invested in an IRA: " + iraPercent + "%");
      System.out.println("Amount of money transfered to savings: $" + saveAmount);
      System.out.println("Amount of money invested into an IRA: $" + iraAmount);
      System.out.println("Total amount of money in savings and IRA is: $"
         + investTotal);
      System.out.println("\nZachary Stall");
      
      //Close files and exit
      console.close();
      System.exit(0);
   }//End main
}//End class      