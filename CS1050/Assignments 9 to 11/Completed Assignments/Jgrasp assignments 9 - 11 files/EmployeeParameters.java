// Define the class with the payrool program parameters

import java.util.Scanner;     // To read the parameter file
import java.io.*;             // To acces File operations

public class EmployeeParameters {
   static private String EMPLOYEE_PARAMETERS = "EmployeeParameters.txt";
                                          // Name of the parameter file
   static private String NL = "\r\n";     // New line for println
   static private String PERCENT = "%";   // Phrase to display percent
   public int maxEmployees;		   // Maximum number of employees 
   public double savingsRate;		   // Savings rate, %
   public double iraRate;           // IRA investment rate, %
   public double federalWithholdingRate;  // Federal withholding tax rate, %
   public double stateWithholdingRate;    // State withholding tax rate, %

   //**************************************************************************

   // Default constructor
   
   public EmployeeParameters() {
      maxEmployees = 0;
      savingsRate  = 0.0;
      iraRate = 0.0;
      federalWithholdingRate = 0.0;
      stateWithholdingRate = 0.0;
   } // End default constructor
   
   //**************************************************************************

   public void getEmployeeParameters() throws IOException {
   
      File parameterFile = new File(EMPLOYEE_PARAMETERS);
      Scanner parameter  = new Scanner(parameterFile);
      
      maxEmployees = parameter.nextInt();
      savingsRate  = parameter.nextDouble();
      iraRate = parameter.nextDouble();
      federalWithholdingRate = parameter.nextDouble();
      stateWithholdingRate = parameter.nextDouble();
   } // End readParameters
   
   //**************************************************************************

   public void displayEmployeeParameters() {
      System.out.println(
         NL + "Maximum # of employees: " + maxEmployees +
         NL + "Savings rate: " + savingsRate + PERCENT +
         NL + "IRA investment rate: " + iraRate + PERCENT +
         NL + "Federal withholdng rate: " + federalWithholdingRate + PERCENT +
         NL + "State withholding rate: "  + stateWithholdingRate + PERCENT);
   } // End displayParameters
   
} // End class
