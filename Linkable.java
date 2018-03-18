//James Gillman
//3/5/2018
//Dominion P3
//Methods needed for Linklists and game.


public interface Linkable 
{
	//MethodName:ShuffleDeck
			//Parameters: TBD
			//Return: None
			//Description: Shuffle decks!
			public void shuffleDeck();
			
			public void createDecks();
			
			//MethodName: removeCard
			//Parameters: TBD
			//Return: NONE
			//Description: Remove card from Players Hand
			public void removeCard();
			
			
			//MethodName:reviveGraveyard
			//Parameters:TBD
			//Return:None
			//Description: Grab Cards from Graveyard and shuffle back into deck
			public void reviveGraveyard();
			
			
			//MethodName: moveCardToHand()
			//Parameters: TBD
			//Return: NONE
			//Description: Grab card from deck and move to players hand.
			public void moveCardToHand();
			
			
			//MethodName: addToHead
			//Parameters: TBD
			//Return:None
			//Description: add Node to head..
			public Node addToHead();
			
}
//Problems: Figuring out what methods are needed.