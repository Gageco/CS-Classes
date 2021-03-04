
public class Card implements Comparable<Card>{
	Rank rank;
	Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	
	//Get/Set Rank
	public Rank getRank() {
		return this.rank;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	//Get/Set Suit
	public Suit getSuit() {
		return this.suit;
	}
	
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	//GetValue
	public int getValue() {
		return this.rank.getFaceValue();
	}
	
	//CompareTo
	public int compareTo(Card that) {
		
		if (this.getValue() == that.getValue()) {
			return 0;
		} else if (this.getValue() < that.getValue()) {
			return -1;
		} else if (this.getValue() > that.getValue()) {
			return 1;
		} 
		return 0;
	}
	
	//ToString
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
	
	
}
