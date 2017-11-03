/* Gross Pay, Savings, and Investment Calculator usiong JOption for I/O.
   This Programs purpose is to calculate gross pay, savings, and investment based
   off of user input in a JOption panel, and be output in a JOption panel.
   Zachary Stall
   Program #3, CS 1050, Section 3
   jGrasp, Custom PC, Windows 10
   Feckless - ineffective; incompetent; futile
   "Absence of evidence is not evidence of absence." -Carl Sagan (1934 - 1996)
*/

import javax.swing.JOptionPane;     // Access the panel class
import java.text.DecimalFormat;     // Access the formatting class
import java.util.StringTokenizer;   // Access the tokenizer class


public class ZacharyStall_2_03 {
   
   public static void main (String [] args) {
   
      double grossPay = 0.0;           // Gross pay
      double savingRate = 0.0;         // Saving rate as a percentage
      double iraRate = 0.0;            // IRA investment rate as a percentage
      double saveAmount = 0.0;         // Calculated savings amount
      double iraAmount = 0.0;          // Calculated IRA amount
      double saveIraCombined = 0.0;    // saving plus ira accounts
      
      String inputStr;                 // Stores user input from the JOption pane
      StringTokenizer eachVarEntered;  // Stores inputs serperated by spaces
      
      /*
      dollarAmount and percenRate will be used to format the final values
      input by the user to include decimals and commas.
      */
      
      DecimalFormat dollarAmountForm = new DecimalFormat("#,##0.00");
      DecimalFormat percentRateForm = new DecimalFormat("0.0");      
                         
      /* 
      JOptionPane.shoInputDialog will print the message in a dialog box
      and allow the user to input values. 
      StringTokenizer will take the input from the user and store the 
      values in eachVarEntered, where the nexToken will take the values
      and store them into each double var below, and know that the
      values are seperated by spaces.
      */
      
      inputStr = JOptionPane.showInputDialog(
      "Enter gross pay, savings rate and IRA rate separated by spaces"); 
      eachVarEntered = new StringTokenizer(inputStr); 
      grossPay = Double.parseDouble(eachVarEntered.nextToken());
      savingRate = Double.parseDouble(eachVarEntered.nextToken());
      iraRate = Double.parseDouble(eachVarEntered.nextToken());
      
      /*
      This section of code calculates the amount of savings, IRA
      investment, and combined total of both accounts and assigns
      them to new var to be used later.
      */
      
      saveAmount = (savingRate / 100.0) * grossPay;
      iraAmount = (iraRate / 100.0) * grossPay;
      saveIraCombined = saveAmount + iraAmount;
                  
      /*
      JoptionPane.showMessgeDialog will print all the values in a 
      new pane for the user to see.
      dollarAmountForm and percentRateForm will take the calculated
      amounts and format them to numbers with commas decimals. 
      */
      
      JOptionPane.showMessageDialog(null, "Gross pay: $" 
         + dollarAmountForm.format(grossPay) 
         + "   savings percent: " + percentRateForm.format(savingRate) + "%"
         + "   savings IRA: " + percentRateForm.format(iraRate) + "% \n"
         + "Amount in Savings: $" + dollarAmountForm.format(saveAmount) + " \n"
         + "Amount in IRA: $" + dollarAmountForm.format(iraAmount) + " \n"
         + "Amount in both accounts: $" + dollarAmountForm.format(saveIraCombined)
         + "\n" + "Zachary Stall");
            
      System.exit(0);
   }
}      