// James Gillman
// 2/7/2018
// Dominion P2
// Stores data from file and then outputs data on a nice display!

import java.io.*;
import java.util.Scanner;

public class DominionPart3JRG 
{
	
	
	public static Scanner input = new Scanner(System.in);
	public static java.io.File inFile;
	public static java.io.File outFile;
	
	
	public static void main(String []args) throws IOException
	{
		PileJRG[ ] stacksOfCards = new PileJRG[15]; //Array of deck of cards!
		
		readInstructions(stacksOfCards);	
		createBoard(stacksOfCards);
	}

	//MethodName: readInstructions
	//Parameters: stackOfCards: 14 Card decks each of a specific card type, value, name, etc.
	//Return: NONE
	//Description: Reads and stores card data from a file.
	public static void readInstructions(PileJRG [] stackOfCards) throws IOException
	{
		inFile = new File("cards.txt");
		Scanner fin = new Scanner(inFile);
		int numberOfCards; //How many cards are of a certain type?
		String cardName; //Name of a dominion card
		String cardType; //Type of card being read in
		int cardCost; //How much does this card cost to buy?
		int victoryPoints; //The amount of victoru points the card gives.
		int worth; //How much does it cost to buy the card?
		int addCards; //Action move to add a card
		int addAction; // Lets you add an action to your turn.
		int addBuy; //Can you buy things!
		
		if (!inFile.exists()) 
		{
			System.out.println("File not Found");
			System.exit(-1);
		}
		
		for (int cardNumber = 0; cardNumber < 14; cardNumber++)
		{
			stackOfCards[cardNumber] = new PileJRG();	
			
			cardType = fin.next();
			fin.nextLine( );
			System.out.println(cardType);
			if(cardType != "*")
			{
				cardName = fin.next( );
				fin.nextLine( );
				numberOfCards = fin.nextInt ( );
				cardCost = fin.nextInt();
		
				if(cardType.equalsIgnoreCase("Victory")) //VICTORY TYPE CARDS GO IN HERE!
				{
					victoryPoints = fin.nextInt ( );
					VictoryJRG victoryCards = new VictoryJRG(cardType, cardName, cardCost, numberOfCards, victoryPoints);
					stackOfCards[cardNumber].setaSingularCard ( victoryCards );
				}
				else if (cardType.equalsIgnoreCase("Treasure")) //TREASURE TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt ( );
					TreasureJRG treasuryCards = new TreasureJRG(cardType, cardName, cardCost, numberOfCards, worth);
					stackOfCards[cardNumber].setaSingularCard ( treasuryCards );	
				}
				else if (cardType.equalsIgnoreCase ("Action")) //ACTION TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt();
					victoryPoints = fin.nextInt();
					addCards = fin.nextInt();
					addAction = fin.nextInt();
					addBuy = fin.nextInt();
				
					ActionJRG actionCards = new ActionJRG(cardType, cardName, numberOfCards, cardCost, worth, victoryPoints, addCards, addAction, addBuy);
					stackOfCards[cardNumber].setaSingularCard ( actionCards );	
				}
				fin.next( );
			}
			System.out.println(cardNumber);
		}
		fin.close();
	}	
	
	//MethodName: createBoard
	//Parameters: stackOfCards: //14 piles of a specific card type, value, name, etc
	//Return:
	//Description: Creates a Dominion logo, "board" and outputs stackOfCards array on the board.
	public static void createBoard(PileJRG [] stackOfCards)
	{
		int i = 0;
		System.out.println("  _____     ____    __  __   _____   _   _   _____    ____    _   _ \n" + 
				" |  __ \\   / __ \\  |  \\/  | |_   _| | \\ | | |_   _|  / __ \\  | \\ | |\n" + 
				" | |  | | | |  | | | \\  / |   | |   |  \\| |   | |   | |  | | |  \\| |\n" + 
				" | |  | | | |  | | | |\\/| |   | |   | . ` |   | |   | |  | | | . ` |\n" + 
				" | |__| | | |__| | | |  | |  _| |_  | |\\  |  _| |_  | |__| | | |\\  |\n" + 
				" |_____/   \\____/  |_|  |_| |_____| |_| \\_| |_____|  \\____/  |_| \\_|\n" + 
				"                                                                    ");
		
		
		outputCard(stackOfCards);
	}
	public static void outputCard(PileJRG[] stackOfCards)
	{
		System.out.println("TREASURE");
		System.out.println("---------------------------------------------------------------------");
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}		
			
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("VICTORY");
		System.out.println("---------------------------------------------------------------------");
		
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}		
			
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("ACTION");
		System.out.println("---------------------------------------------------------------------");
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}
		}
		System.out.println();
		for (int i = 0; i < 14; i++ )
		{
			if(stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType());
			}		
			
		}
	}
}
//Problems: Being able to get victory points to output.