// James Gillman
// 3/26/2018
// Dominion P7
// Plays a whole game of dominion. 

import java.io.*;
import java.util.Scanner;

public class DominionPart7JRG 
{
	public static Scanner input = new Scanner(System.in);
	public static java.io.File inFile;
	public static java.io.File outFile;
	
	
	public static void main(String []args) throws IOException
	{
		boolean gameDone = false;
		int pAns = 0;
		PileJRG[ ] stacksOfCards = new PileJRG[20]; //Array of deck of cards!
		PlayerNode plist = new PlayerNode();
		
		readInCards(stacksOfCards);
		pAns = createPlayers(stacksOfCards, plist);
		input.nextLine();
		
		while(gameDone == false)
		{
			plist = plist.getLink();
			dominionMenu(stacksOfCards, plist);
			
			gameDone = checkCards(stacksOfCards);
		}
		plist = plist.getLink();
		calculateFinalScores(plist, pAns);
	}
	
	//methodName: createPlayers
	//Parameters: stacksOfCards: array of every card type/name in the game. plist: circular linklist of players.
	//Return: pAns: total amount of players.
	//Description: Asks how many players are going to be created and creats a circular linked list to do it.
	public static int createPlayers(PileJRG[] stacksOfCards, PlayerNode plist)
	{
		int pAns;
		System.out.println("WELCOME TO DOMININION! HOW MANY PLAYERS ARE PLAYING TODAY!?");
		pAns = input.nextInt();
		plist.createPlayers(pAns, stacksOfCards);	
		return pAns;
	}
	
	//MethodName: dominionMenu
	//Parameters: stacksOfCards: array of every card type/name in the game. plist: circular linklist of players. 
	//Return: NONE
	//Description: Creates and allows the player to select different moves throughout the game.
	public static void dominionMenu(PileJRG []stacksOfCards, PlayerNode plist)
	{
		int goldAmount;
		int buyAmount = plist.getLink().getaPlayer().getPlayerHand().calculateBuys();
		if (buyAmount == 0) //sets amount of buy moves they can do to one always, otherwise cards step in.
		{
			buyAmount = 1;
		}
		int addActions = plist.getLink().getaPlayer().getPlayerHand().calculateActions();
		char answer;
		do
		{
			System.out.print("ITS YOUR TURN PLAYER: ");
			
			System.out.print(plist.getLink().getaPlayer().getPlayerID() + 1);
			System.out.println("!");
			
			System.out.println("*----------------------------------------*");
			System.out.println("|        WHAT DO YOU WANT TO DO?         |");
			System.out.println("*----------------------------------------*");
			System.out.println("| H: View Board and Current Players Hand |");
			System.out.println("| B: Buy a Card                          |");
			System.out.println("| Q: End Your Turn!                      |");
			System.out.println("|----------------------------------------|");
			System.out.println("| Total Actions In Hand Is: " + addActions +"            |");
			System.out.println("| Total Buys Left Is: " + buyAmount +"                  |");
			System.out.println("*----------------------------------------*");
			
			answer = input.nextLine().toUpperCase().charAt(0);
	
			switch(answer)
			{
				case('H'):
				{
					createBoard(stacksOfCards);
					plist.getLink().getaPlayer().getPlayerHand().printHand();
					break;
				}
				case('B'):
				{				
					if(buyAmount > 0)
					{
						createBoard(stacksOfCards);
						goldAmount = plist.getLink().getaPlayer().getPlayerHand().calculateGold();
						goldAmount = buyingACard(stacksOfCards, plist, goldAmount);
						buyAmount --;
						break;
					}
					else
					{
						System.out.println("You don't have any buys left. Choose something else...");
					}
				}
				case ('Q'):
				{
					System.out.println("Discarding all Cards in hand");
					plist.getLink().getaPlayer().getPlayerHand().cleanHand(plist.getLink().getaPlayer().getPlayerDeck(), plist.getLink().getaPlayer().getPlayerHand(), plist.getLink().getaPlayer().getPlayerDiscard());	
				}
			}	
		}while(answer != 'Q');
	}
	
	//MethodName: buyingACard
	//Parameters:  stacksOfCards: array of every card type/name in the game. plist: circular linklist of players. goldAmount: how much gold does the player have?
	//Return: goldAmount
	//Description: Allows player to buy a card and sends it to their discard.
	public static int buyingACard(PileJRG []stacksOfCards, PlayerNode plist, int goldAmount)
	{
		int cardChoice;
		System.out.println("Choose the card you want to buy.");
		System.out.println("You have [" + goldAmount + "] gold available to spend!");
		cardChoice = input.nextInt();
		if(stacksOfCards[cardChoice].getaSingularCard().getCardCost() <= goldAmount)
		{
			System.out.println("Adding to discard");
			goldAmount = goldAmount - stacksOfCards[cardChoice].getaSingularCard().getCardCost();
			plist.getLink().getaPlayer().getPlayerDiscard().addToDecks(stacksOfCards[cardChoice].getaSingularCard());
			stacksOfCards[cardChoice].setCardAmount(stacksOfCards[cardChoice].getCardAmount() - 1);
			String junk = input.nextLine();
			System.out.println(junk);
		}
		else
		{
			System.out.println("Whoops! Looks like you don't have enough.");
			System.out.println("Press Enter To Go back to the Menu");
			String junk = input.nextLine();
			System.out.println(junk);
			input.nextLine();
		}
		return goldAmount;
	}
	
	//MethodName: checkCards
	//Parameters: stackOfCards:
	//Return: boolean of whether or not the array has three decks empty.
	//Description: Checks the cards in each of the array
	public static boolean checkCards(PileJRG []stackOfCards)
	{
		int emptyStack = 0;
		for(int i = 0; i < stackOfCards.length; i++)
		{
			if(stackOfCards[i].getCardAmount() == 0)
			{
				emptyStack++;
			}
		}
			if(emptyStack <= 3)
			{
				return true;
			}
			else
			{
				return false;
			}
	}

	//MethodName: calculateFinalScores
	//Parameters: plist: circular linkedlist of players, pAns: how many players are currently playing?
	//Return: NONE
	//Description: Calculates the final scores of each player and declares winners.
	public static void calculateFinalScores(PlayerNode plist, int pAns)	
	{
		plist = plist.getLink();
		int totalPoints = 0;
		for (int i = 0; i < pAns; i++)
		{
			totalPoints = plist.getLink().getaPlayer().getPlayerDeck().calculateVictoryPoints();
			totalPoints = totalPoints + plist.getLink().getaPlayer().getPlayerHand().calculateVictoryPoints();
			totalPoints = totalPoints + plist.getLink().getaPlayer().getPlayerDiscard().calculateVictoryPoints();
			System.out.println("Player " + (plist.getLink().getaPlayer().getPlayerID() + 1) + "'s final score is" + totalPoints);
			plist = plist.getLink();
		}
	}
	
	//MethodName: readInCards
	//Parameters: stackOfCards: Piles of specific card types, values, name, etc.
	//Return: NONE
	//Description: Reads and stores card data from a file.
	public static void readInCards(PileJRG [] stackOfCards) throws IOException
	{
		inFile = new File("cards.txt");
		Scanner fin = new Scanner(inFile);
		int numberOfCards; //How many cards are of a certain type?
		String cardName; //Name of a dominion card
		String cardType; //Type of card being read in
		int cardCost; //How much does this card cost to buy?
		int victoryPoints; //The amount of victory points the card gives.
		int worth; //How much does it cost to buy the card?
		int addCards; //Action move to add a card
		int addAction; // Lets you add an action to your turn.
		int addBuy; //Can you buy things!
		//String specialInfo;
		boolean oneAsterisk = false; //Has the first asterisk in the file been reached?
		
		if (!inFile.exists()) 
		{
			System.out.println("File not Found");
			System.exit(-1);
		}
		
		for (int cardNumber = 0; cardNumber < stackOfCards.length; cardNumber++)
		{
			stackOfCards[cardNumber] = new PileJRG();	
			
			cardType = fin.next();
			fin.nextLine( );
			cardName = fin.next( );
			fin.nextLine( );
			
			if (cardName.equals("*") || cardType.equals("*"))
			{
				oneAsterisk = true;
			}
			if (oneAsterisk == false)	
			{
				numberOfCards = fin.nextInt ( );
				cardCost = fin.nextInt();
				if(cardType.equalsIgnoreCase("Victory")) //VICTORY TYPE CARDS GO IN HERE!
				{
					victoryPoints = fin.nextInt ( );
					//specialInfo = fin.nextLine();
					VictoryJRG victoryCards = new VictoryJRG(cardType, cardName, cardCost, victoryPoints);
					stackOfCards[cardNumber].setaSingularCard ( victoryCards );
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
					fin.next( );
				}
				else if (cardType.equalsIgnoreCase("Treasure")) //TREASURE TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt ( );
					//specialInfo = fin.nextLine();
					TreasureJRG treasuryCards = new TreasureJRG(cardType, cardName, cardCost, worth);
					stackOfCards[cardNumber].setaSingularCard ( treasuryCards );
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
					fin.next( );
				}
				else if (cardType.equalsIgnoreCase ("Action")) //ACTION TYPE CARDS GO IN HERE!
				{
					worth = fin.nextInt();
					victoryPoints = fin.nextInt();
					addCards = fin.nextInt();
					addAction = fin.nextInt();
					addBuy = fin.nextInt();
					//specialInfo = fin.nextLine();
					ActionJRG actionCards = new ActionJRG(cardType, cardName, cardCost, worth, victoryPoints, addCards, addAction, addBuy);
					stackOfCards[cardNumber].setaSingularCard ( actionCards );	
					stackOfCards[cardNumber].setCardAmount(numberOfCards);
					fin.next( );
				}
				fin.nextLine( );
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
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("TREASURE");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Treasure"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType() + "[" + i +"] ");
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
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("VICTORY");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType() + "[" + i + "] ");
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
				System.out.print("     " + stackOfCards[i].getaSingularCard().getVictoryPoints() + "     ");
			}		
		}
		System.out.println();
		System.out.print("CARDS LEFT: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Victory"))
			{
				System.out.print("  " + stackOfCards[i].getCardAmount() + "       ");
			}		
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("ACTION ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("CARD TYPE: ");
		for (int i = 0; i < 20; i++ )
		{
			if( stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print(stackOfCards[i].getaSingularCard().getCardType() + "[" + i +"] ");
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
		System.out.print("CARD COST: ");
		for (int i = 0; i < 20; i++ )
		{
			if(stackOfCards[i].getCardAmount() != -1 && stackOfCards[i].getaSingularCard().getCardType().equalsIgnoreCase("Action"))
			{
				System.out.print("  " + stackOfCards[i].getaSingularCard().getCardCost() + "        ");
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
				System.out.print("" + stackOfCards[i].getCardAmount() + "         ");
			}		
		}
		System.out.println("\n");
	}
}
//Problems: Getting Circular linked list working, pretty sure I have discard working, shuff working properly, tons of things, a lot of learning was done.