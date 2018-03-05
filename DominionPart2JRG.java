// James Gillman
// 2/7/2018
// Dominion P2
// Stores data from file and then outputs data on a nice display!

import java.io.*;
import java.util.Scanner;

public class DominionPart2JRG 
{
	
	
	public static Scanner input = new Scanner(System.in);
	public static java.io.File inFile;
	public static java.io.File outFile;
	
	
	public static void main(String []args) throws IOException
	{
		PileJRG[ ] stacksOfCards = new PileJRG[14]; //14 Card decks each of a specific card type, value, name, etc.
		
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
		//createDecks();
		for(int index = 0; index < 14; index++)
		{
			stackOfCards[index] = new PileJRG();
			
			cardType = fin.next();
			fin.nextLine ( );
			cardName = fin.next( );
			fin.nextLine ( );
			numberOfCards = fin.nextInt ( );
			cardCost = fin.nextInt();
		
			if(cardType.equalsIgnoreCase("Victory")) //VICTORY TYPE CARDS GO IN HERE!
			{
				victoryPoints = fin.nextInt ( );
				VictoryJRG victoryCards = new VictoryJRG(cardType, cardName, cardCost, numberOfCards, victoryPoints);
				stackOfCards[index].setaSingularCard ( victoryCards );
				fin.next( );	
			}
			else if (cardType.equalsIgnoreCase("Treasure")) //TREASURE TYPE CARDS GO IN HERE!
			{
				worth = fin.nextInt ( );
				TreasureJRG treasuryCards = new TreasureJRG(cardType, cardName, cardCost, numberOfCards, worth);
				stackOfCards[index].setaSingularCard ( treasuryCards );
				fin.next( );	
			}
			else if (cardType.equalsIgnoreCase ("Action")) //ACTION TYPE CARDS GO IN HERE!
			{
				worth = fin.nextInt();
				victoryPoints = fin.nextInt();
				addCards = fin.nextInt();
				addAction = fin.nextInt();
				addBuy = fin.nextInt();
				
				ActionJRG actionCards = new ActionJRG(cardType, cardName, numberOfCards, cardCost, worth, victoryPoints, addCards, addAction, addBuy);
				stackOfCards[index].setaSingularCard ( actionCards );
				fin.next ( );	
			}		
		}	
	}	
	
	//MethodName: createBoard
	//Parameters: stackOfCards: //14 piles of a specific card type, value, name, etc
	//Return:
	//Description: Creates a Dominion logo, "board" and outputs stackOfCards array on the board.
	public static void createBoard(PileJRG [] stackOfCards)
	{
		System.out.println("  _____     ____    __  __   _____   _   _   _____    ____    _   _ \n" + 
				" |  __ \\   / __ \\  |  \\/  | |_   _| | \\ | | |_   _|  / __ \\  | \\ | |\n" + 
				" | |  | | | |  | | | \\  / |   | |   |  \\| |   | |   | |  | | |  \\| |\n" + 
				" | |  | | | |  | | | |\\/| |   | |   | . ` |   | |   | |  | | | . ` |\n" + 
				" | |__| | | |__| | | |  | |  _| |_  | |\\  |  _| |_  | |__| | | |\\  |\n" + 
				" |_____/   \\____/  |_|  |_| |_____| |_| \\_| |_____|  \\____/  |_| \\_|\n" + 
				"                                                                    ");
		
		System.out.println("    +------------+---------+------------+----------+-----------+\n" + 
				"    |   VICTORY  | VICTORY |   ACTION   | TREASURE |  TREASURE |\n" + 
				"    |    (V2)    |   (V3)  |    (A1)    |   (T3)   |   (T2)    |\n" + 
				"    |   "+ stackOfCards[1].getaSingularCard ( ).cardName +"    | "+ stackOfCards[2].getaSingularCard ( ).cardName +"| "+ stackOfCards[6].getaSingularCard ( ).cardName +" |   "+ stackOfCards[5].getaSingularCard ( ).cardName +"   |   "+ stackOfCards[4].getaSingularCard ( ).cardName +"  |\n" + 
				"    | Cost: "+ stackOfCards[1].getaSingularCard ( ).cardCost +"    |   "+ stackOfCards[2].getaSingularCard ( ).cardCost +"     |    "+ stackOfCards[6].getaSingularCard ( ).cardCost+"      |   "+ stackOfCards[5].getaSingularCard ( ).cardCost +"      |   "+ stackOfCards[4].getaSingularCard ( ).cardCost +"       |\n" + 
				"    | Left: "+ stackOfCards[1].getaSingularCard ( ).numberOfCards +"   |   "+ stackOfCards[2].getaSingularCard ( ).numberOfCards+"    |    "+ stackOfCards[6].getaSingularCard ( ).numberOfCards +"       |   "+ stackOfCards[5].getaSingularCard ( ).numberOfCards +"     |   "+ stackOfCards[4].getaSingularCard ( ).numberOfCards +"      |\n" + 
				"    | VP:   "+ stackOfCards[1].getaSingularCard ( ).getVictoryPoints() +"    |   "+ stackOfCards[2].getaSingularCard ( ).getVictoryPoints() +"     |            |          |           |\n" + 
				"    |            |         |            |          |           |\n" + 
				"    +------------+---------+------------+----------+-----------+\n" + 
				"    |  VICTORY   |  ACTION |   ACTION   |  ACTION  |  TREASURE |\n" + 
				"    |    (V1)    |   (A2)  |    (A3)    |   (A4)   |    (T1)   |\n" + 
				"    |   "+ stackOfCards[0].getaSingularCard ( ).cardName +"   | "+ stackOfCards[7].getaSingularCard ( ).cardName +" |   "+ stackOfCards[8].getaSingularCard ( ).cardName +"   | "+ stackOfCards[9].getaSingularCard ( ).cardName +" |   "+stackOfCards[3].getaSingularCard ( ).cardName +"  |\n" + 
				"    | Cost: "+ stackOfCards[0].getaSingularCard ( ).cardCost +"    |   "+ stackOfCards[7].getaSingularCard ( ).cardCost +"    |     "+ stackOfCards[8].getaSingularCard ( ).cardCost +"     |   "+ stackOfCards[9].getaSingularCard ( ).cardCost +"     |     "+ stackOfCards[3].getaSingularCard ( ).cardCost +"     |\n" + 
				"    | Left: "+ stackOfCards[0].getaSingularCard ( ).numberOfCards +"   |   "+ stackOfCards[7].getaSingularCard ( ).numberOfCards +"     |     "+ stackOfCards[8].getaSingularCard ( ).numberOfCards +"      |   "+ stackOfCards[9].getaSingularCard ( ).numberOfCards +"      |     "+ stackOfCards[3].getaSingularCard ( ).numberOfCards +"    |\n" + 
				"    | VP:   "+ stackOfCards[0].getaSingularCard ().getVictoryPoints() +"    |         |            |          |           |\n" + 
				"    |            |         |            |          |           |\n" + 
				"    +------------+---------+------------+----------+-----------+\n" + 
				"    |   ACTION   |  ACTION |            |  ACTION  |   ACTION  |\n" + 
				"    |    (A5)    |   (A6)  |            |   (A7)   |    (A8)   |\n" + 
				"    |  "+ stackOfCards[10].getaSingularCard ( ).cardName +"  |"+ stackOfCards[11].getaSingularCard ( ).cardName +"            |  "+ stackOfCards[12].getaSingularCard ( ).cardName +"  |   "+ stackOfCards[13].getaSingularCard ( ).cardName +"  |\n" + 
				"    | Cost: "+ stackOfCards[10].getaSingularCard ( ).cardCost +"   |   "+ stackOfCards[11].getaSingularCard ( ).cardCost +"    |            |    "+ stackOfCards[12].getaSingularCard ( ).cardCost +"    |   "+ stackOfCards[13].getaSingularCard ( ).cardCost +"      |\n" + 
				"    | Left: "+ stackOfCards[10].getaSingularCard ( ).numberOfCards +"    |   "+ stackOfCards[11].getaSingularCard ( ).numberOfCards +"     |            |    "+ stackOfCards[12].getaSingularCard ( ).numberOfCards +"     |   "+ stackOfCards[13].getaSingularCard ( ).numberOfCards +"       |\n" + 
				"    |            |         |            |          |           |\n" + 
				"    +------------+---------+            +----------+-----------+");
	}
	
}
//Problems: Being able to get victory points to output.