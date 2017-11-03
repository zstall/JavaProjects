/* Using methods, this program asks the user to input gross pay, savings
   rate, and IRA investment rate. The program will store the values and
   calculate the amount of money saved, invested, and sum of both combined.
   
   This program purpose is to mirror assignment two while using methods.
   Methods used:
      explain() - explain the program to the user
      userInput() - prompts user to input data needed
      calcMoney() - calculates saving and IRA amounts from percentages
      outPutData() - formats and outputs data to user
   
   Zachary Stall
   Program #5, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   
   Pedantic - Characterized by a narrow, often ostentatious concern for
   book learning and formal rules.
   
   "To be yourself in a world that is constantly trying to make you 
   something else is the greatest accomplishment." 
   -Waldo Emerson (1803 - 1882)
*/

import java.util.Scanner;  // For console input

public class ZacharyStall_2_05 { 

   static Scanner console = new Scanner(System.in);
   static Toolkit tools   = new Toolkit();

   public static void main (String [] args) { 
      double grossPay = 0.0;     // gross pay
      double savingRate = 0.0;   // percentage rate to be saved
      double iraRate = 0.0;      // percentage rate of be invested in IRA
      double savingAmount = 0.0; // dollar amount in savings
      double iraAmount = 0.0;    // dollar amount in IRA

      // Explain the program to the user
      
      explain();
      
      // Input the gross pay, saving rate, and IRA rate
      // userInput string prompts user to input parameter
      
      grossPay = userInput("gross pay (without commas)");
      savingRate = userInput("saving % as a number (i.e. 5.5% = 5.5)");
      iraRate = userInput("IRA % as a number (i.e. 12% = 12)");

      // Determine the amount in savings and IRA accounts
      
      savingAmount = calcMoney(grossPay, savingRate);
      iraAmount = calcMoney(grossPay, iraRate);
      
      // Output the results
      
      outputData(grossPay, savingRate, iraRate, savingAmount, iraAmount); 
      
      System.exit(0);
   } // End main
   
   // **************************************************************
  
   // Methods section
   
   // Explain the program to the user
   
   public static void explain() { 
      System.out.println(
            "The user will input gross pay, saving percentage rate, " +
            "and IRA percentage investment rate. \n\n" +
            "The program will use gross pay and the percentages" +
            " to calculate saving amount, \n" + 
            "IRA investment amount, and a total of both accounts. \n\n" +
            "Finaly the program will output gross pay, percentages and " +
            "the calculated values in dollars. \n\n" +
            "Note: This program uses methods. \n\n" +
            "Zachary Stall \n");
   } // End explain
   
   // ***************************************************************
   
   /*
      userInput will prompt and collect the gross pay, savings rate, and
      IRA investment rate from the user. userInput will also check that 
      the user is inputing positive numbers, and if not post an error message
      to the user and have them re-enter the number. 
      
   */
   
   public static double userInput(String str) {
      double number;
      System.out.print("Enter the " + str + ": ");
      number = console.nextDouble();
      
      // if statement to check input is postive, ask for new value if negative                      
      while(number < 0) {
         System.out.print("Error, must be a positive number. \n" +
         "Enter the " + str + ": ");
         number = console.nextDouble();
      }
      return number;
   } // End userInput method
   
   // ***************************************************************
  
   // Returns rate percentage of g amount (savings and IRA in this program)
   
   public static double calcMoney(double g, double rate) {
      return rate / 100.0 * g; // calculates amount of money based off of percentage rate
   }  // End calcMoney
   
   // ***************************************************************

   // Output gross pay, savings rate, IRA rate, savings amount, and IRA amount fromatted
   
   public static void outputData(double gp,
                                 double saver,
                                 double irar,
                                 double savea,
                                 double iraa) {
   
      System.out.print(
         "\n" + "The gross pay entered: " + tools.leftPad(gp, 15, "$###,##0.00") +
         "\n" + "The savings rate entered: " + tools.leftPad(saver, 11, "#0.0") + "%" +
         "\n" + "The savings amount is: " + tools.leftPad(savea, 15, "$##,##0.00") +
         "\n" + "The IRA investment rate: " + tools.leftPad(irar, 12, "#0.0") + "%" +
         "\n" + "The IRA amount invested is: " + tools.leftPad(iraa, 10, "$##,##0.00") +
         "\n" + "Savings and IRA is: " + tools.leftPad(iraa + savea, 18, "$##,##0.00"));
   } // End outputData
   
} // End class