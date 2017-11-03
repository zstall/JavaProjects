/* Mileage reimbursement program for Mathematical Association of America 
   
   This programs purpose is to take the data in a file starting
   with how many data values are in the file followed by that number
   of mileages data values. The program reads these data values 
   and stores them into an array. It will perform calculations on 
   the array to create a reimbursement array.
   We are given the base amount, and rates that should be reimbursed 
   to drivers on a scale for how far they drove.
   The program uses methods to do all calculations, input/output to 
   files, and output to the console. 
   
   Zachary Stall
   Program #8, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   
   Aplomb - Self-confident assurance, skill, and poise - especially
   in difficult or challenging circumstances.
   
   "If you don't think every day is a good day, just try missing one." 
   -Cavett Robert (1907 - 1997)
*/

import java.util.Scanner;  // For console input
import java.io.*;          // Access PrintWriter and related classes


public class ZacharyStall_2_08 { 

   static Toolkit tools   = new Toolkit();
   static Scanner console = new Scanner(System.in);
    
   public static void main (String [] args) throws IOException { 
        
      // Access the input/output method
      final String INPUT_FILE  = "ZacharyStall_2_08_Input.txt";
      final String OUTPUT_FILE = "ZacharyStall_2_08_Output.txt";
      
      int totalPosVal      = 0;    // Number of positive mileages
      int dataValue        = 0;    // Number of data values
      int nRead            = 0;    // Number of values read from input file
      
      double[] miles;              // Mileage array to calculate Reimb
      double[] reimb;              // Reimb array to stroe calculated reimb
      double milesAverage = 0.0;   // mileage average
      double reimbAverage = 0.0;   // reimburesement average
            
      double totalMileage  = 0.0;  // Sum of all the miles
      double totalReimb    = 0.0;  // Sum of all reimbersement
      
      // Access the input/output files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Begin program execution
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");
           
      // dataValue is the first number in the input file, number of data values
      dataValue = inputFile.nextInt();
      
      // Establish the length of the arrays
      miles = new double [dataValue];
      reimb = new double [dataValue];
      
      // Get the mileages into the mileage array and check how many data points
      // are read from the input file.
      nRead = getMileageArray(inputFile, miles);
      
      
      // Ensure the # of mileages read is the same as the number of pairs
      // indicated at the start of the input file.
      if (dataValue != nRead) {
         System.out.println(
            "The # of entries in the input file doesn't match header value." +
            "\nProgram terminated.");
            System.exit(0);
      } // End if


      // Calculate the reimb amount and store in in the reimb array
      calcReimbAmount(miles, reimb, nRead);      
      
      // Prints the headers for the table
      displayHeader(outputFile);
      
      // Prints the detail lines in the table
      displayTableData(outputFile, miles, reimb, nRead); 
   
      // Calculate the average miles driven and average reimbursement
      milesAverage = getAverages(miles, nRead);
      reimbAverage = getAverages(reimb, nRead);
      
      // Calculate the sums of miles and reimbursements
      totalMileage = getSum(miles, nRead);
      totalReimb   = getSum(reimb, nRead);
      
      // Caluclate total postive mileage values processed
      totalPosVal = getPositiveMiles(miles, nRead);
      
      // Using methods to output formatted data to the console and output file
      outputData(outputFile, 
                 totalReimb, 
                 totalMileage, 
                 reimbAverage, 
                 milesAverage, 
                 dataValue, 
                 totalPosVal);
    
      
      inputFile.close();
      outputFile.close();
      
      System.exit(0);  
   } // End Main

   // *********************************************************************
   
   // Method for headers
   public static void displayHeader(PrintWriter output) {
      String str;
      String str2;
      str = "This program uses an input file of mileage and " +
         "the reimbursement amount." + "\r\n" +
         "It stores the data into arrays." + "\r\n" +
         "The program uses methods to perform operations on " +
         "the arrays." + "\r\n" +
         "Then it prints the information to the " +
         "user on the console," + "\r\n" +
         "and into an output file.\r\n\r\n";
       
      str2 = tools.padString("Mileage", 10, " ", "") +
                       tools.padString("Reimbursement", 20, " ", "") +
                       "\r\n" +
                       tools.padString("-------", 10, " ", "") +
                       tools.padString("-------------", 20, " ", "") +
                       "\r\n";
                                  
     System.out.print(str);
     output.print(str);
                                   
     System.out.print(str2);
     output.print(str2);
   } // End headers
     
   // *********************************************************************
  
   // Method to read and store the mileages into an array
   public static int getMileageArray(Scanner input, double[] array) {
      int len = array.length;      
      int nRead = 0;                      // number of values read
      
      while (input.hasNext() && nRead < len) {
         array[nRead] = input.nextDouble();
         nRead++;
         }
      return nRead; 
   }
     
   // *********************************************************************
   // Method to Calculate reimbursement amount
   public static void calcReimbAmount(double[] arrayMiles, 
                                     double[] arrayReimb,
                                     int      nElements) {
      
      double mileDriven    = 0.0;
      double reimbMoney    = 0.0;
      double rate          = 0.0;
      double base          = 0.0;
      double overage       = 0.0;
       
          for (int i = 0; i < nElements; i++) {
      
          mileDriven = arrayMiles[i];
         
         // Checks to see if mileage is less than zero...
         // if it is, will print five stars for reimbursement
         if(mileDriven <= 0) {
            arrayReimb[i] = 0;           
            continue;
         }
         
         // Checks for miles and assigns appropriate values for base, rate, and overage
         else if (mileDriven <  400) {
            base =   0; rate = 0.18; overage = mileDriven;
         }
         else if (mileDriven <  900) {
            base =  65; rate = 0.15; overage = mileDriven - 400;
         }
         else if (mileDriven < 1300) {
            base = 115; rate = 0.12; overage = mileDriven - 900;
         }
         else if (mileDriven < 1900) {
            base = 140; rate = 0.10; overage = mileDriven - 1300;
         }
         else if (mileDriven < 2600) {
            base = 165; rate = 0.08; overage = mileDriven - 1900;
         }
         else {
            base = 195; rate = 0.06; overage = mileDriven - 2600;
         } 
         
         // Calculate and output the reimbursement amount and calculate running totals
         reimbMoney = base + (rate * overage);
         
         // Stores the Reimb amount into the reimb array
         arrayReimb[i] = reimbMoney;   
      } // End loop
                                           
   } // End calcReimbAmount method

   
   // *********************************************************************
   // Method to display table
   public static void displayTableData(PrintWriter output,
                                       double[] mileage,
                                       double[] reimbAmount,
                                       int      nElements) {
   
      double mileDriven  = 0.0;
      double reimbMoney = 0.0;
      String mileReimbStr;
      
      for(int i = 0; i < nElements; i++) {
      
         mileDriven = mileage[i];
         reimbMoney = reimbAmount[i];
      
         if(mileDriven <= 0) {                         
            System.out.println(tools.leftPad(mileDriven, 10, "##,##0.0") +
                               tools.padString("*****", 20, " ", ""));
            output.println(tools.leftPad(mileDriven, 10, "##,##0.0") +
                               tools.padString("*****", 20, " ", ""));
            continue;
         } // End if statement
      
         // Output the table of data to the counsole and the output file
         mileReimbStr = 
            tools.leftPad(mileDriven, 10, "##,##0.0") +
            tools.leftPad(reimbMoney, 20, "$#,##0.00");
         
         System.out.println(mileReimbStr);
         output.println(mileReimbStr);
      } // End for loop
      
   } // End displayTableData
         
   // *********************************************************************
   // Calculate the average of miles and reimb
   public static double getAverages(double[] array, int nElements) {
   
      int dataPoints = 0;
      double sum     = 0.0;          
      double average = 0.0;
            
      for(int i = 0; i < nElements; i++) {
         if(array[i] > 0) {
            dataPoints++;
            sum += array[i];
         } // End if statement
         
         if (dataPoints != 0) {
            average = (double)sum / dataPoints;
         } // End if statement
      } // End for loop            
      return average;
   } // End getAverages method
          
  
   // *********************************************************************
   // Calculate the average of miles and reimb
   public static double getSum(double[] array, int nElements) {
      double sum = 0.0;
      
      for(int i = 0; i < nElements; i++) {
         if(array[i] >= 0) {
            sum += array[i];
         } // End if      
      } // End for
      return sum;
   } // End getSum
   
   // *********************************************************************
   // Sum the number of postive mileage values in the mile array
   public static int getPositiveMiles(double[] array, int nElements) {
      int sum = 0;
      
      for(int i = 0; i < nElements; i++) {
         if(array[i] > 0) {
            sum ++;
         } // End if      
      } // End for
      return sum;
   } // End getSum
  
   // *********************************************************************
   // Method for output

   public static void outputData(
                                 PrintWriter output, 
                                 double sumRiemb, 
                                 double sumMile,
                                 double avgReimb,
                                 double avgMile, 
                                 double sumValue, 
                                 int sumPosVal) 
      {
      String str2;
      str2 =  "\r\n" + "Total amount of reimburesment: " + 
               tools.leftPad(sumRiemb, 10, "$#,##0.00") +
               "\r\n" + "Total amount of mileage: " + 
               tools.leftPad(sumMile, 15, "##,##0.0") +
               "\r\n" + "Average of reimburesment: " +
               tools.leftPad(avgReimb, 15, "$##0.00") +
               "\r\n" + "Average of mileage driven: " +
               tools.leftPad(avgMile, 13, "##0.0") +
               "\r\n" + "Total values processed: " + 
               tools.leftPad(sumValue, 14, "##0") +
               "\r\n" + "Total positive (mi) values: " + 
               tools.leftPad(sumPosVal, 10, "##0");
               
      System.out.print(str2);
      output.println(str2);
       
      } // End outputData   
} // End Class