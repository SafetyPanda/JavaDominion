//James Gillman
//3/5/2018
//Dominion P3
//Methods needed for Cardlists and game.


public interface Linkable 
{
			public void shuffleDeck();
			
			public void createDecks();
			
			public void removeCard();

			public void reviveGraveyard();
			
			public void moveCardToHand();

			public void addToDeck(CardJRG aSingularCard);
			
			public void printLink();
			
}
//Problems: Figuring out what methods are needed.