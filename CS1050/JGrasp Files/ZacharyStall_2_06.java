/* Mileage reimbursement program for Mathematical Association of America 
   
   This programs purpose is to take the data in a file starting
   with how many data values are in the file followed by that number
   of mileages data values. The program reads these data values 
   and then writes them into a new file while calculating the 
   reimbursement amounts.
   We are given the base amount, and rates that should be reimbursed 
   to drivers on a scale for how far they drove.
   
   Zachary Stall
   Program #6, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   
   Attenuate - to make thin or slender.
   
   "The best way to predict the future is to create it." 
   -Peter Drucker (1909 - 2005)
*/

import java.util.Scanner;  // For console input
import java.io.*;          // Access PrintWriter and related classes


public class ZacharyStall_2_06 { 

   static Toolkit tools   = new Toolkit();
   static Scanner console = new Scanner(System.in);
    
   public static void main (String [] args) throws IOException { 
        
      // Access the input/output method
      final String INPUT_FILE  = "ZacharyStall_2_06_Input.txt";
      final String OUTPUT_FILE = "ZacharyStall_2_06_Output.txt";
      
      int totalPosVal      = 0;    // Number of positive mileages
      double dataValue     = 0;    // Number of data values
      double mileDriven    = 0.0;  // Mileage driven
      double base          = 0.0;  // Base amount for reimbursement
      double rate          = 0.0;  // Rate per mile to reimburse
      double overage       = 0.0;  // Mileage overage which to calc rate per mile
      double reimbMoney    = 0.0;  // Any money owed over base rates
      
      double totalMileage  = 0.0;  // Sum of all the miles
      double totalReimb    = 0.0;  // Sum of all reimbersement
      
      String mileReimbStr; 
            
      // Access the input/output files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Begin program execution
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");
            
      // Prints the headers for the table
      displayHeader(outputFile);
      
      // dataValue is the first number in the input file, number of data values
      dataValue = inputFile.nextDouble();
            
      // While loop to go through input file and create data table
      while(inputFile.hasNext()) {
         
         // Gets the next value in the input file and stores it         
         mileDriven = inputFile.nextDouble();
         
         // Checks to see if mileage is less than zero...
         // if it is, will print five stars for reimbursement
         if(mileDriven <= 0) {                         
            System.out.println(tools.leftPad(mileDriven, 10, "##,##0.0") +
                               tools.padString("*****", 20, " ", ""));
            outputFile.println(tools.leftPad(mileDriven, 10, "##,##0.0") +
                               tools.padString("*****", 20, " ", ""));
            continue;
         }
         
         // Checks for miles and assigns appropriate values for base, rate, and overage
         else if (mileDriven <  400) {base =   0; rate = 0.18; overage = mileDriven;}
         else if (mileDriven <  900) {base =  65; rate = 0.15; overage = mileDriven - 400;}
         else if (mileDriven < 1300) {base = 115; rate = 0.12; overage = mileDriven - 900;}
         else if (mileDriven < 1900) {base = 140; rate = 0.10; overage = mileDriven - 1300;}
         else if (mileDriven < 2600) {base = 165; rate = 0.08; overage = mileDriven - 1900;}
         else    {base = 195; rate = 0.06; overage = mileDriven - 2600;} 
         
         // Calculate and output the reimbursement amount and calculate running totals
         reimbMoney = base + (rate * overage);
         totalMileage += mileDriven;
         totalReimb += reimbMoney;
         totalPosVal++;
         
         // Output the table of data to the counsole and the output file
         mileReimbStr = 
            tools.leftPad(mileDriven, 10, "##,##0.0") +
            tools.leftPad(reimbMoney, 20, "$#,##0.00");
         
         System.out.println(mileReimbStr);
         outputFile.println(mileReimbStr);
      } // End while loop        
      
      // Using methods to output formatted data to the console and output file
      outputData(outputFile, totalReimb, totalMileage, dataValue, totalPosVal);
    
      inputFile.close();
      outputFile.close();
      
      System.exit(0);  
   } // End Main

   // *********************************************************************
   
   // Method for headers
   public static void displayHeader(PrintWriter output) {
      String str; 
      str = tools.padString("Mileage", 10, " ", "") +
                       tools.padString("Reimbursement", 20, " ", "") +
                       "\r\n" +
                       tools.padString("-------", 10, " ", "") +
                       tools.padString("-------------", 20, " ", "") +
                       "\r\n";
                                  
     System.out.print(str);
     output.println(str);
   } // End headers
   
  // *********************************************************************
   
   // Method for output
   public static void outputData(
                                 PrintWriter output, 
                                 double sumRiemb, 
                                 double sumMile, 
                                 double sumValue, 
                                 int sumPosVal) 
      {
      String str2;
      str2 =  "\r\n" + "Total amount of reimburesment: " + 
               tools.leftPad(sumRiemb, 10, "$#,##0.00") +
               "\r\n" + "Total amount of mileage: " + 
               tools.leftPad(sumMile, 15, "##,##0.0") +
               "\r\n" + "Total values processed: " + 
               tools.leftPad(sumValue, 14, "##0") +
               "\r\n" + "Total positive (mi) values: " + 
               tools.leftPad(sumPosVal, 10, "##0");
               
      System.out.print(str2);
      output.println(str2);
       
      } // End outputData   
} // End Class