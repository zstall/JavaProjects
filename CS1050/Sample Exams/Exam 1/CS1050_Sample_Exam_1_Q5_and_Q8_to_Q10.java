// This file contains answers to questions 5 and 8-10 on Sample Exam 1. 
// *** This program compiles with errors!

// 5.	(a)	Nested if

	if (B >= 2 && B <= 9) 
	{
		if (C == 0)
		{
			B *= 4;
			S += 3;
		}
	}
	else
	{
		S -= 6;
	}

// 5. (b)	While loop

	B = 24;
	while (B != 999)
	{
		if (B > 0)
		{
			M += 4*B;
		}
		B = AR(B,M);	
	}
	FINISHED = true;

// 5. (c)   For loop
   
   for (D = 0, L = 8; L <= 35; D += FS(Y), L+=3)
   {
      Y = Way(L);
   }
   
   A = D;
   
// 5. (d)   Do-While loop

   A = S;
   do
   {
      if (A <= 150)
      {
         MAT(A,L);
      }
      A = Cdk(A,L);
   } while(A != 0); 
   Okay = false;  

// ***********************  Question 8  ***********************

switch (B)
{
   case 5:
   case 7: B += 2; 
           break;
   case 8: CORRECT = 0;
           break;
   case 4: Msg = "OKAY";          
           Proc(B);
           break;
   default: Msg = "invalid";
}

// ***********************  Question 9  ***********************

// The code from the loop must be repeated before the loop starts
// because a do-while loop executes at least once. The *equivalent*
// code must work if B starts out as 100.

B += FN(B);
B = Find(B);

while (B != 100)
{
   B += FN(B);
   B = Find(B);
}

// ***********************  Question 10  ***********************

public static double AB(int b, int a)
{
   double weightedAverage;
   weightedAverage = (double) (2*b + 4*a) / 6.0;
   return weightedAverage;
}