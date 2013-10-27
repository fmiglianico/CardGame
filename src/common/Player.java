package common;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class Player {
	private LinkedList<Card> hand;
	private String name;
	
	public Player(String name) {
		hand = new LinkedList<Card>();
		this.setName(name);
	}

	public LinkedList<Card> getHand() {
		return hand;
	}

	public void setHand(LinkedList<Card> hand) {
		this.hand = hand;
	}
	
	public boolean hasNoCards() {
		return hand.isEmpty();
	}
	
	public int getNbCards() {
		return hand.size();
	}
	
	public void take(Card c) {
		if(c != null)
			hand.addLast(c);
	}
	
	@Override
	public String toString() {
		String ret = "Hand :\n";
		for(int hi = 0; hi < hand.size(); hi++)
			ret += hand.get(hi).toString() + "\n";
		return ret;
	}

	public void takeAll(LinkedList<Card> cardList) {
		hand.addAll(cardList);
	}
	
	public Card play() {
		Card c = null;
		try {
			c = hand.pop();
		} catch(NoSuchElementException e) {
			return null;
		}
		return c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
