package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.println ("How much money do you start with? ");
		double startAmount = in.nextDouble();
		double currentBalance = startAmount;
		System.out.println ("What is the win chance? (in %) ");
		double winChance = in.nextDouble ();
		winChance = winChance / 100.0;
		int counter;
		System.out.println ("What is the win limit? ");
		double winLimit = in.nextDouble ();
		int numWin =0;
		int numRuin = 0; 
		System.out.println ("How many day's would you like to simulate? ");
		int totalSimulations = in.nextInt ();
		for (int i = 0; i < totalSimulations; i++)
		{
			counter = 0;
			currentBalance = startAmount;
			while (currentBalance >= 0 && currentBalance <= winLimit)
			{
				double randomNumber = (double)Math.random(); 
				counter++;
				if (randomNumber <= winChance) {
					currentBalance += 1.0;
					//					System.out.println ("You win!");
				}
				else
				{
					currentBalance -= 1.0;
					//					System.out.println ("Aw, you lost!");
				}
			}
			if (currentBalance >= winLimit) {
				numWin = numWin + 1;
				System.out.println ("Simulation day: " + i);
				System.out.println (counter + " plays took place today");
				System.out.println ("Day was good!");
			} else {
				numRuin = numRuin + 1;
				System.out.println ("Simulation day: " + i);
				System.out.println (counter + " plays took place today");
				System.out.println ("Day was bad!");


			}

		}
		if( winChance==0.5) {
			double expectedRuin = 1- (startAmount/winLimit);
		}
		else {
			double a = (1-winChance)/ winChance; 
			double expectedRuin = ((double)Math.pow(a,startAmount)-(double) Math.pow(a,winLimit)/ ((1- (double) Math.pow (- a,winLimit))));
		}
	}

}
