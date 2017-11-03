// EmployeeMain - Driver for the Employee class, assignment 10

import java.util.Scanner;
import java.io.*;

public class EmployeeMainTest {

   static Toolkit tools = new Toolkit();
   static final int MAX_EMPL = 30;
   
   public static void main(String[ ] args) throws IOException {
   
      EmployeeParameters emplParams = new EmployeeParameters();
      
      Scanner input = new Scanner(new File("ZacharyStall_2_10_Input.txt"));
      Employee[] empl = new Employee[MAX_EMPL];
      int nRead = 0;
      int sortResult = 0;
      double savingsRate = 0.0;
      
      // Get the program parameters. If there's any argument in the
      // command line, display the parameters, too
      
      emplParams.getEmployeeParameters();
      savingsRate = emplParams.savingsRate;
      if (args.length > 0) {
         emplParams.displayEmployeeParameters();
         System.out.println();            // Blank line after parameters
      }
      // Read and display the imput file
      
      while (input.hasNext() && (nRead < empl.length)) {
         empl[nRead] = new Employee();
         empl[nRead].hoursWorked = input.nextDouble();
         empl[nRead].payRate = input.nextDouble();
         empl[nRead].name = input.nextLine().trim();
         empl[nRead].grossPay = empl[nRead].hoursWorked * 
                                empl[nRead].payRate;
         nRead++;
      } // End while
      
      System.out.println("\n# of rows read: " + nRead);
      input.close();

      displayData("Input", empl, nRead);
      
      // Sort by name and print, the sort by gross pay and print
      
      sortResult = tools.selectionSortArrayOfClass(empl, nRead, "Name");
      displayData("Name", empl, nRead);
      
      sortResult = tools.selectionSortArrayOfClass(empl, nRead, "Gross Pay");
      displayData("Gross Pay", empl, nRead);
   } // End main
   
   //************************************************************************
   
   public static void displayData(String printOrder,
                                  Employee[] empl,
                                  int nEntries) {
      final String DOLLAR = "#,##0.00";
      
      System.out.println("\nPrint in " + 
                         printOrder.toLowerCase() + " order\n");

      for (int i = 0; i < nEntries; i++) {
         System.out.println(        tools.padString(empl[i].name,20) + 
                            "   " + tools.leftPad(empl[i].payRate, 10, DOLLAR) + 
                            "   " + tools.leftPad(empl[i].hoursWorked, 10, DOLLAR) +
                            "   " + tools.leftPad(empl[i].grossPay, 10, DOLLAR));
      } // End displayData
   } // End displayData
   
} // End class