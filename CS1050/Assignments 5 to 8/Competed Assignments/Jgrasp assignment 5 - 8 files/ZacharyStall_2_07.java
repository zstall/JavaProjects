/* Percentage Grade Processor

   The purpose of this program is to read student names and 
   percentage scores. Based on the percentage score the student
   earns, the program will classify it, and print the 
   student name, score, and a message. The scores are recorded
   from a .txt file, and written to a .txt file (and echode to
   console).
      
   Zachary Stall
   Program #7, CS 1050, Section 2
   jGRASP, Custom PC, Windows 10
   
   Egalitarian - Asserting, resulting from, or characterized
   by belief in the equality of all people, especially in
   political, economic, or social life.
   
   "Freedom is never give; it is won" 
   -A. Philio Randolph (1889 - 1979)
*/

import java.util.Scanner;  // For console input
import java.io.*;          // Access PrintWriter and related classes


public class ZacharyStall_2_07 {
   
   static Toolkit tools = new Toolkit();
   static Scanner console = new Scanner(System.in);
   
   public static void main (String [] args) throws IOException {
   
      // Access the input/output method
      final String INPUT_FILE  = "ZacharyStall_2_07_Input.txt";
      final String OUTPUT_FILE = "ZacharyStall_2_07_Output.txt";
      
      // Declare all var
      int grade      = 0;    // grade for each student
      int dataValues = 0;    // Total number of input values processed
      int totalCsBs  = 0;    // Total number of grades between 70 - 89
      
      double sumCsBs          = 0.0;   // Sum of CsBs to calc avg
      double sumAllScore      = 0.0;   // Sum of all grade to calc avg      
      double avgCsBs          = 0.0;   // Average of grades between 70 - 89
      double avgAllScores     = 0.0;   // Average of all grades
      
      String name;      // Var to store names of students
      String message;   // Var to store the message for grade
      String table;     // Data output str
      
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
      
      // Process the data from the input file
      while(inputFile.hasNext()) {
      
         grade = inputFile.nextInt();  // First # always a grade
         name  = inputFile.nextLine();  // Next is student name
         name  = name.trim();          // Trims leading and trailing spaces
         dataValues ++;                // counts number of grades processed
         sumAllScore += grade;         // sums all grades
         
         if(grade >= 90) {
            message = "OUTSTANDING";
         }
         else if(grade >= 70) {
            message = "Satisfactory";
            totalCsBs ++;
            sumCsBs += grade;
         }
         else {
            message = "Failing";
         }
         
         table = tools.padString(name, 20, "", " ") +
                 tools.leftPad(grade, 5, "##0") +
                 tools.padString(message, 18, " ", " ");

         outputFile.println(table);
         System.out.println(table);         
      
      }
      
      // Get the average of C's & B's and Total
      avgCsBs = getAverage(totalCsBs, sumCsBs);
      avgAllScores = getAverage(dataValues, sumAllScore);      
      
      // Output information to console and file
      outputMessage(outputFile, dataValues, totalCsBs, avgCsBs, avgAllScores);
      
      
      inputFile.close();
      outputFile.close();
      
      System.exit(0); 
   
   } // End Main  
   
   // *********************************************************************
   // Method for the header of the program
   public static void displayHeader(PrintWriter output) {
      String str;
      str = tools.padString("Name", 22, "", " ") +
            tools.padString("Grade", 7, "", " ") +
            tools.padString("Message", 11, " ", "") +
            "\r\n" +
            "-------------------- " +
            "------- " +
            "---------------";
     
     System.out.println(str);
     output.println(str);
     
   } // End headers
   
   // *********************************************************************
   public static double getAverage(int numberItems, double sum) {
      return (double) sum / numberItems;
   } // End getAverage
   
   // *********************************************************************
   public static void outputMessage(PrintWriter output,
                                    int dataLine,
                                    int numSat,
                                    double avgSat,
                                    double avgAllGrade)
   {
      String str;
      str = "\r\n" + 
            "The number of grades processed is: " +
            dataLine + "\r\n" +
            "The number of scores that are \"Satisfactory\": " +
            numSat + "\r\n" +
            "The average of the \"Satisfacotry\" Scores: " +
            tools.leftPad(avgSat, 0, "##0.0") + "%" + "\r\n" +
            "The average of all the scores: " +
            tools.leftPad(avgAllGrade, 0, "##0.0") + "%" + "\r\n";
            
      System.out.print(str);
      output.print(str);
    } // End outputMessage 
    
   // *********************************************************************
                                       
      
} // End class