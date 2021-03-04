import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface {
	public static int deckSize = 52;
	public Card[] cards;
	public int nextCardIndex = 0;
	
	public DeckOfCards() {
		cards = new Card[deckSize];
		int count = 0;
		
		for (Rank rank00 : Rank.values()) {
			for (Suit suit00 : Suit.values()) {
				cards[count] = new Card(rank00, suit00);
				
				count++;
				
//				System.out.println(count);
			}
		}
	}

	public String toString() {
		String retString = "[";
		
		for (int i = 0; i < cards.length; i++) {
			if (i != cards.length-1) {
				retString += cards[i].toString() + ", ";
			} else {
				retString += cards[i];
			}
			
		}
		
		retString += "]";
		
		return retString;
	}
	
	//Swap Cards
	private void swap(int tic, int tak) {
		Card holder = this.cards[tic];
//		System.out.println("Tic Location, Value: " + tic + ", " + this.bubbleArray[tic]);
//		System.out.println("Tak Location, Value: " + tak + ", " + this.bubbleArray[tak]);
		this.cards[tic] = this.cards[tak];
		this.cards[tak] = holder;
		
	}
	

	@Override
	public void shuffle() {
		Random rand = new Random();
		
		for (int i = 0; i < cards.length; i++) {
			int j = rand.nextInt(cards.length);
			swap(i, j);
		}
		
	}

	@Override
	public Card draw() {
		this.nextCardIndex += 1;
		if (this.nextCardIndex != this.deckSize+1) {
			return this.cards[this.nextCardIndex-1];
		}
		return null;
	}

	@Override
	public int numCardsRemaining() {
		return deckSize - nextCardIndex;
	}

	@Override
	public int numCardsDealt() {
		return nextCardIndex;
	}

	@Override
	public Card[] dealtCards() {
		Card[] tempCard = new Card[nextCardIndex];
		for (int i = 0; i < nextCardIndex; i++) {
			tempCard[i] = cards[i];
		}
		
		return tempCard;
	}

	@Override
	public Card[] remainingCards() {
		Card[] tempCard = new Card[deckSize - nextCardIndex];
		for (int i = nextCardIndex; i < (deckSize); i++) {
			tempCard[i - nextCardIndex] = cards[i];
		}
		
		return tempCard;
	}
	
	
}
