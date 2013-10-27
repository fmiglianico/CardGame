package common;

public class Card {
	private int value;
	private int suit;

	private enum Values {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	private enum Suits {SPADE, HEART, DIAMOND, CLUB};
	
	public Card(int value, int suit)
	{
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	@Override
	public String toString() {
		return Values.values()[value] + " of " + Suits.values()[suit];
	}
	
	public int compareTo(Card other) {
		if (this.value < other.value)
			return -1;
		else if (this.value > other.value)
			return 1;
		return 0;
	}
}
