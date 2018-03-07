// James Gillman
// 3/5/2018
// Dominion P3
// Stores data from file and then outputs data on a nice display! Beginnings of linkedList forming in the LinkList package.

import java.io.*;
import java.util.Scanner;

public class DominionPart3JRG 
{
	
	
	public static Scanner input = new Scanner(System.in);
	public static java.io.File inFile;
	public static java.io.File outFile;
	
	
	public static void main(String []args) throws IOException
	{
		PileJRG[ ] stacksOfCards = new PileJRG[20]; //Array of deck of cards!
		LinkList.Linkable.shuffleDeck();;
		
		readInstructions(stacksOfCards);	
		createBoard(stacksOfCards);
	}

	//MethodName: readInstructions
	//Parameters: stackOfCards: Piles of specific card types, values, name, etc.
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
		boolean oneAsterisk = false; //Has the first asterisk in the file been reached?
		
		if (!inFile.exists()) 
		{
			System.out.println("File not Found");
			System.exit(-1);
		}
		
		for (int cardNumber = 0; cardNumber < 20; cardNumber++)
		{
			stackOfCards[cardNumber] = new PileJRG();	
			
			cardType = fin.next();
			fin.nextLine( );
			cardName = fin.next( );
			if (cardName.equals("*"))
			{
				oneAsterisk = true;
			}
			if (oneAsterisk == false)	
			{
				fin.nextLine( );
				numberOfCards = fin.nextInt ( );
				cardCost = fin.nextInt();
		
				if(cardType.equalsIgnoreCase("Victory")) //VICTORY TYPE CARDS GO IN HERE!
				{
					victoryPoints = fin.nextInt ( );
					VictoryJRG victoryCards = new VictoryJRG(cardType, cardName, cardCost, victoryPoints);
					stackOfCards[cardNumber].setaSingularCard ( victoryCards );
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
				}
				else if (cardType.equalsIgnoreCase("Treasure")) //TREASURE TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt ( );
					TreasureJRG treasuryCards = new TreasureJRG(cardType, cardName, cardCost, worth);
					stackOfCards[cardNumber].setaSingularCard ( treasuryCards );
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
				}
				else if (cardType.equalsIgnoreCase ("Action")) //ACTION TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt();
					victoryPoints = fin.nextInt();
					addCards = fin.nextInt();
					addAction = fin.nextInt();
					addBuy = fin.nextInt();
				
					ActionJRG actionCards = new ActionJRG(cardType, cardName, cardCost, worth, victoryPoints, addCards, addAction, addBuy);
					stackOfCards[cardNumber].setaSingularCard ( actionCards );	
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
				}
				fin.next( );
			}
			else
			{
				stackOfCards[cardNumber].setCardAmount(-1);
			}
		}
		fin.close();
	}	
	
	//MethodName: createBoard
	//Parameters: stackOfCards: Piles of specific card types, values, name, etc.
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
		outputCard(stackOfCards);
	}
	
	
	//MethodName: outputCard
	//Parameters: stackOfCards: Piles of specific card types, values, name, etc.
	//Return: None
	//Description: Outputs all piles in array onto a nice organized game board. (CAN PROBABLY PUT IT INTO NICER METHODS...)
	public static void outputCard(PileJRG[] stackOfCards)
	{
		System.out.println("---------------------------------------------------------------------");
		System.out.println("TREASURE");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType() + "    ");
			}
		}
		System.out.println();
		System.out.print("CARD NAME: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(" " + stackOfCards[i].getaSingularCard().getCardName() + "     ");
			}
		}
		System.out.println();
		System.out.print("CARD COST: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print("    " + stackOfCards[i].getaSingularCard().getCardCost() + "      ");
			}		
		}
		System.out.println();
		System.out.print("CARDS LEFT: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print("  " + stackOfCards[i].getCardAmount() + "        ");
			}		
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("VICTORY");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType() + "    ");
			}
		}
		System.out.println();
		System.out.print("CARD NAME: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory") && stackOfCards[i].getCardAmount() != -1)
			{
				System.out.print(" " + stackOfCards[i].getaSingularCard().getCardName() + "    ");
			}
		}
		System.out.println();
		System.out.print("CARD COST: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print("    " + stackOfCards[i].getaSingularCard().getCardCost() + "      ");
			}		
		}
		System.out.println();
		System.out.print("V-POINTS: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print("    " + stackOfCards[i].getaSingularCard().getVictoryPoints() + "      ");
			}		
		}
		System.out.println();
		System.out.print("CARDS LEFT: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(" " + stackOfCards[i].getCardAmount() + "         ");
			}		
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("ACTION");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if( stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(" " + stackOfCards[i].getaSingularCard().getCardType() + "    ");
			}
		}
		System.out.println();
		System.out.print("CARD NAME: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardName() + "   ");			
			}
		}
		System.out.println();
		System.out.print("ADD BUY: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print("    " + stackOfCards[i].getaSingularCard().getAddBuy() + "      ");
			}			
		}
		System.out.println();
		System.out.print("ADD CARDS: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print("  " + stackOfCards[i].getaSingularCard().getAddCards() + "        ");
			}		
		}
		System.out.println();
		System.out.print("ADD ACTION: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(" " + stackOfCards[i].getaSingularCard().getAddAction() + "         ");
			}		
		}
		System.out.println();
		System.out.print("CARDS LEFT: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(" " + stackOfCards[i].getCardAmount() + "        ");
			}		
		}
	}
}
//Problems: Being able to get victory points, action stuff to output, and making output look nice, WILL BE CREATING METHODS FOR ALL OF IT..