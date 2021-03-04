//Happy Thanksgiving!
public class WarGames {
	public static void main(String[] args) {
		int rounds = 0;
		
		if (args.length != 1) {
			System.out.println("Usage: WarGames <num-rounds>");
			System.exit(0);
		}
		
		try {
			rounds = Integer.parseInt(args[0]);
			System.out.println("Playing " + rounds + " Rounds of War!");
		} catch (Exception e) {
			System.out.println("Not a valid argument, quitting");
			System.exit(0);
		}
		
		//Setting Up Deck
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		System.out.println("Shuffling The Cards!\n");
		
		//For Loop For War Rounds
		for (int i = 0; i < rounds; i++) {
			System.out.println("\nRound " + i + "...");
			Card p1Card = deck.draw();
			Card p2Card = deck.draw();
			
			System.out.println("Player 1 has a " + p1Card.toString() + "\nPlayer 2 has a " + p2Card.toString());
			
			int compareCards = p1Card.compareTo(p2Card);
			if (compareCards > 0) {
				System.out.println("Player 1 has a bigger card and wins!");
			} else if (compareCards < 0) {
				System.out.println("Player 2 has a bigger card and wins!");
			} else {
				System.out.println("It is a tie!");
			}
		}
		
	}
}
