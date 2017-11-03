/* 
   This program calculates the saving and investment amounts based
   off of gross pay, saving rate, and investment rate all input 
   by the user.
   
   This program calculates these values using methods in a separate
   Java class named ZacharyStall_2_09_Calc. This class has three
   private instance variables for the gross pay, savings rate, and
   IRA investment rate.  
   
   Zachary Stall
   Program #9, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   
   Campestral - of or relating to fields or open country.
   
   "The only place success comes before work is in the dictionary." 
   -Vince Lombardi (1913 - 1970)
*/

public class ZacharyStall_2_09 {
   
   static Toolkit tools = new Toolkit();
   
   public static void main (String [] args){
   
      // Create an instance of ZacharyStall_2_09_Calc.
      ZacharyStall_2_09_Calc theMoney = new ZacharyStall_2_09_Calc();
      
      double savingsMoney; // amount of money in savings
      double iraMoney;     // amount of money in IRA
      double sumOfMoney;   // amount of money in both accounts
      
      // Explain the program to the user.
      explain();
      
      // Get the gross pay, savings rate, IRA rate from the user.
      theMoney.getNumbers();
      
      // Calculate the savings amount.
      savingsMoney = theMoney.calcSavingAmount();
      
      // Calculate the IRA amount.
      iraMoney = theMoney.calcIraAmount();
      
      // Calculate the sum in savings and IRA account.
      sumOfMoney = savingsMoney + iraMoney;
      
      // Print all the data to the console for the user.
      outPut(theMoney, savingsMoney, iraMoney, sumOfMoney);
   }
   
   // Methods:
   // ***********************************************************************
   
   // Explanation of the program to the user.
   public static void explain() {
      System.out.println("Hello, this program will allow you to enter your:\n" +
         "gross pay\n" +
         "savings rate\n" +
         "IRA investment rate\n" +
         "\nThis program uses a seperate class to do all calculations.\n" +
         "It will use the gross pay enterd, and calculate your savings and \n" +
         "IRA investments based off of the perventages you input.\n" +
         "Zachary Stall\n");
   } // End explain
   
   // ***********************************************************************
   
   // Prints all the data to the user on the console.
   public static void outPut(ZacharyStall_2_09_Calc numbers, 
                             double moneySave,
                             double moneyIra,
                             double moneySum) {
      numbers.printOut();
      System.out.println(
         "\nThe savings amount is: " + tools.leftPad(moneySave, 15, "$##,##0.00") +
         "\nThe IRA amount invested is: " + tools.leftPad(moneyIra, 10, "$##,##0.00") +
         "\nAmount in both accounts: " + tools.leftPad(moneySum, 13, "$##,##0.00"));
   } // End outPut

} // End Class