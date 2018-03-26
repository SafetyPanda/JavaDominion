//James Gillman
//3/5/2018
//Dominion P3
//Methods needed for Cardlists and game.


public interface Linkable 
{
			public void shuffleDeck();
			
			public void addToDecks(CardJRG aSingularCard);
			
			public void findStartingCards(CardList playerDeck, PileJRG [] stackOfCards);
			
			public void removeCardFromDeck(CardList playerDiscard);
			
			public void removeCardFromDiscard(CardList playerDeck);

			public void reviveGraveyard(CardList playerDeck, CardList playerDiscard);
			
			public void moveCardToHand(CardList playerDeck, CardList playerHand, CardList playerDiscard, int cardDraw);
			
			public void printLink();
			
			public void printHand();
			
			public int calculateGold();
}
//Problems: Figuring out what methods are needed.