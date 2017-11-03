/* This is a seperat Java class that contains three
   private instance variables of type double for the
   gross pay, savings rate, and IRA investment rate.
   This class will be called by another maine method.
   
   Methods:
      Zachary_2_09_Calc() - default constructor initializes grosspay,
         savings rate, and ira rate to zero
      Zachary_2_09_Calc(double val1, double val2, double val3) - constructor
         that initializes grosspay to val1, savingsRate to val2, and
         iraRate to val3
      getNumber() - Allows the user to input values for
         each var using the keyboard
      getAmounts(String moneyRate) - method used to get amounts from
         keyboard and check that user is putting in valid inputs.
      printOut() - prints out the values that have been input with
         appropriate message
      savingsAmount() - calculates and return amount in savings
      iraAmount() - calculate and returns amount invested in IRA
*/

import java.util.Scanner;

public class ZacharyStall_2_09_Calc {

   // Instance var to get/calc gross pay, savings rate,
   // and IRA investment percentage
   private double grossPay, savingsRate, iraRate;
   
   // Establish the keyboard
   Scanner console = new Scanner(System.in);
   static Toolkit tools = new Toolkit();
   
   // ****************************************************************
   
   // Default (no arg) constructor - initialize grossPay, savingsRate,
   // and iraInvest to zero
   public ZacharyStall_2_09_Calc() {
      grossPay    = 0.0;
      savingsRate = 0.0;
      iraRate   = 0.0;  
   } // End initialization of var
   
   // ****************************************************************
   
   // Constructor (3-arg) - initialize grossPay to val1,
   // savingsRate to val2 and iraInvest to val3
   public ZacharyStall_2_09_Calc(double val1, double val2, double val3) { 
     grossPay    = val1;
     savingsRate = val2;
     iraRate   = val3;
   } // End ZacharyStall_2_09)Calc(double val1, double val2, double val3
   
   // ****************************************************************
   
   /* Get values of grossPay, savingsRate, and iraInvest from the user
    * This method uses another method.
    */
    
   public void getNumbers() { 
     grossPay = getAmounts("gross pay amount:");
     savingsRate = getAmounts("savings rate:");
     iraRate = getAmounts("IRA invesmtment rate:");
   } // End getNumbers
   
   // **************************************************************
   
   // Get a single number
   public double getAmounts(String moneyRate) {
     double amount;
     System.out.print("Enter your " + moneyRate);
     amount = console.nextDouble();
     
     if(amount <= 0) {
      System.out.println("Not an acceptable input.");
      getNumbers();
     }
     
     return amount;
   } // End getAmounts
   
   // **************************************************************
   public void printOut() {
   
      System.out.print("\nThe gross pay is: " + 
                       tools.leftPad(grossPay, 20, "$##,##0.00") + "\n" +
                       "The savings rate is: " + 
                       tools.leftPad(savingsRate, 16, "##0.0") + "\n" +
                       "The IRA investment rate is: " + 
                       tools.leftPad(iraRate, 9, "##0.0"));   
   } // End printOut
   
   // **************************************************************
   
   // calculate the amount of money in savings from gross pay and the 
   // savings rate
   public double savingAmount() {
      return (savingsRate / 100) * grossPay;
   } // End savingAmount
   
   // **************************************************************
   
   // Calculate the amount in the IRA account based off fo the gross pay
   // and the IRA investment rate
   public double iraAmount() {
      return (iraRate / 100) * grossPay;
   } // End iraAmount
   
   
} // End Class