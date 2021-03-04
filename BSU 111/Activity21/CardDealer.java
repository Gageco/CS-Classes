
public class CardDealer {
	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		
		System.out.println(deck.toString());
		
		deck.shuffle();
		
		System.out.println(deck.toString());
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(i + ": " + deck.draw().toString());
			}	
		} catch (NullPointerException e) {
			System.out.println("End of Deck");
		}
		
		System.out.println("Number Of Cards Remaining: " + deck.numCardsRemaining());
		System.out.println("Number Of Cards Dealt: " + deck.numCardsDealt());
		
		//Testing Dealt Cards
		Card[] dealtCards = deck.dealtCards();
		String dealtCardsString = "Cards Dealt: [";
		
		for (int i = 0; i < dealtCards.length; i++) {
			if (i != dealtCards.length - 1) {
				dealtCardsString += dealtCards[i] + ", ";
			} else {
				dealtCardsString += dealtCards[i] + "]";
			}
		}
		System.out.println(dealtCardsString);
		
		//Testing Remaining Cards
		Card[] remainingCards = deck.remainingCards();
		String remainingCardsString = "Cards Remaining: [";
		for (int i = 0; i < remainingCards.length; i++) {
			if (i != remainingCards.length) {
				remainingCardsString += remainingCards[i].toString();
			} else {
				remainingCardsString += remainingCards[i].toString() + "]";
			}
		}
		System.out.println(remainingCardsString + ", " + remainingCards.length);
		
	}
}
