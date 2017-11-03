import java.util.Scanner; 

public class CS1050_Sample_Exam_1_Q11
{
   static Scanner console = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      double number1, number2;
      double wax;
      
      System.out.print("The first number to use in the weighted average: ");
      number1 = console.nextDouble();
      System.out.print("The second number to use in the weighted average: ");
      number2 = console.nextDouble();
      wax = (2.0 * number1 + 4.0 * number2) / 6.0;
      
      System.out.println(
            "The two numbers are " + number1 + " and " + number2 + "\n" +
            "The weighted average is " + wax + "\n" +
            "\n" +
            "John Doe");

      System.exit(0);
   }
}