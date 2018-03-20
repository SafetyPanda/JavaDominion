//James Gillman
//3/5/2018
//Dominion P3
//Methods needed for Cardlists and game.


public interface Linkable 
{
			public void shuffleDeck();
			
			public void addToDecks(CardJRG aSingularCard);
			
			public void findStartingCards(CardList playerDeck, PileJRG [] stackOfCards, String cardNeeded);
			
			public void removeCard();

			public void reviveGraveyard();
			
			public void moveCardToHand();
			
			public void printLink();
			
}
//Problems: Figuring out what methods are needed.