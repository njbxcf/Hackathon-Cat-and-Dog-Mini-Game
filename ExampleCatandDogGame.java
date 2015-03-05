/**
 * 
 */
package natalie;

/**
 * @author Natalie
 *
 */
import java.util.Scanner;
import java.util.Random;

public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println("Hello!");
		String openPhrase = "Welcome to the game Cat and Dog. "
				+ "The object of the game is to get to the total of 30 points first.\n"
				+ "If you, the dog, roll a one, then the pot that you can collect turns to zero and it's the cat's turn.";
		
		System.out.println(openPhrase);
		
		//First loop. Controls the whole game
		System.out.println("Would you lke to play Cat and Dog?");
		///////////////////////////////////////
		char yes = 'y';
		char roll= 'r';
		//////////////////////////////////////
		
		Scanner user_input = new Scanner( System.in );
		String userChoice = user_input.next();
		
		boolean GameOver = false; ///this will end the loop whenever the game rules says the game is over
		if (userChoice.toLowerCase().charAt(0) == yes)
		{
			System.out.println("You can go first!");
		} else 
		{
			System.out.println("Maybe another day!");//Sometimes somebody doesn't want to play
			GameOver = true;
		}
		
		boolean computerTurn = false;//this is so the user starts first
		
		// Identifiers
		/////////////
		int catPot = 0;
		int dogPot = 0; 
		int dogScore = dogPot;
		int catScore = catPot;
		
		Random rand = new Random();
		String rollPrompt = "Would you like to 'R'oll the dice?\t";
		Scanner userContinue_prompt = new Scanner( System.in );
		
		
		while (GameOver != true)
		{
			System.out.println("\nUsers Score= "+ dogScore + "\t Computers Score= "+ catScore + "\n");
			
			//this is user/dog's turn info
			while (computerTurn == false)//this will happen if it's not the computer's turn
			{
				System.out.println(rollPrompt);
				String userContinue = userContinue_prompt.next();
				if (userContinue.toLowerCase().charAt(0) != roll)//If the user does not want to roll. Here are the closing information
				{
					dogScore += dogPot;
					dogPot = 0;
					System.out.println("\nUsers Score= "+ dogScore + "\t Computers Score= "+ catScore + "\n");
					computerTurn = true;
					break;
				}
				
				//This is for the dice
				int Dice = rand.nextInt(7);
				
				if (Dice == 0)
					Dice = rand.nextInt(7);
				if (Dice == 1)//this is the twist in the game with the one rule
				{
					dogPot = 0;
					System.out.printf("What a shame, a one was rolled! Pot cleared to " + dogPot + " and your turn is over.\n");
					break;
				}
				dogPot = (dogPot + Dice);
				System.out.println("\tThe dice is " + Dice + "\t\tPot is currently " + dogPot);
				
				if ( (dogScore + dogPot)>=30)//checking to see if the person has won, we don't want them to have to keep rolling if they already won
				{
					System.out.println("You won!");
					dogScore= (dogScore + dogPot);
					GameOver = true;
					computerTurn=false;
					break;
				}
				
			}
			dogScore = (dogScore + dogPot);
			if ((dogScore)>=30)
			{
				GameOver = true;
				computerTurn=false;
				break;
			}
			
			computerTurn = true;
			//////////////////////////Computer's Turn
			System.out.println("It's the cat computer's turn.");
			while (computerTurn == true)
			{
				int Dice2 = rand.nextInt(7);
				
				if (Dice2 == 0)
					Dice2 = rand.nextInt(7);
				if (Dice2 == 1)
				{
					catPot = 0;
					System.out.printf("A one was rolled! Pot cleared to " + catPot + " and Cat's turn is over.\n");
					computerTurn = false;
					break;
				}
				
				if((catScore + catPot)>=30)
				{
					System.out.println("The Computer Won!");
		            computerTurn=false;
		            GameOver=true;
		            break;
				}
				Dice2 = rand.nextInt(7);
				catPot = catPot + Dice2;
				System.out.println("\tThe dice is " + Dice2 + "\t\tPot is currently " + catPot);
				
				if (catPot >= 7)
				{
					catScore = catPot;
					System.out.println("The cat has chosen to end it's turn.");
					
					computerTurn= false;
					catPot= 0;
					break;
				}
			}
				
		}
		//Final information
		System.out.println("Your Score was " + dogScore);
		System.out.println("The Cat Computers Score was "+ (catScore));
		System.out.println("Thanks for playing!");
	}
}
	
